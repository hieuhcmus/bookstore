package com.mum.edu.ea.webstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mum.edu.ea.webstore.config.UserAdapter;
import com.mum.edu.ea.webstore.entity.Order;
import com.mum.edu.ea.webstore.entity.OrderPriceQuantity;
import com.mum.edu.ea.webstore.entity.OrderStatus;
import com.mum.edu.ea.webstore.entity.Person;
import com.mum.edu.ea.webstore.service.MessagingService;
import com.mum.edu.ea.webstore.service.OrderLineService;
import com.mum.edu.ea.webstore.service.OrderService;
import com.mum.edu.ea.webstore.service.PersonService;

@Controller
@SessionAttributes(value = "order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderLineService orderLineService;

	@Autowired
	private MessagingService messagingService;

	@Autowired
	private PersonService personService;

	@ModelAttribute("order")
	public Order gerOrder() {
		return new Order();
	}

	@GetMapping("/shopping-cart")
	public String createOrderPage(Model model, @ModelAttribute("order") Order order) {
		model.addAttribute("ShoppingCart", order);

		if (order.getOrderLine().isEmpty())
			return "redirect:/product/all";
		else
			return "shoppingCart";
	}

	@PostMapping("/order")
	public String createOrder(Order order) {
		orderService.saveOrder(order);
		return "redirect:/";
	}

	@GetMapping("/confirmed-order")
	public String createConfirmedOrderPage(Model model, @ModelAttribute("order") Order order) {
		model.addAttribute("confirmedOrder", order);

		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);
		return "confirmedOrder";
	}

	@GetMapping("/checkout")
	public String checkoutOrder(Model model, @ModelAttribute("order") Order order, SessionStatus status,
			Authentication authentication) {
		order.setOrderStatus(OrderStatus.CONFIRMED);

		UserAdapter userAdapter = (UserAdapter) authentication.getPrincipal();
		List<Person> persons = personService.findByEmail(userAdapter.getUser().getEmail());
		order.setPerson(persons.get(0));

		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("orderDescription", order);
		status.setComplete();

		order.setTotalPrice(totalPrice);
		orderService.saveOrder(order);

		// send JMS message to inventory app
		messagingService.sendMessage(order, totalQuantities, totalPrice);

		return "orderDescription";
	}

	@GetMapping("/orders-admin")
	public String getOrdersListPage(Model model) {
		ArrayList<Order> orderList = (ArrayList<Order>) orderService.findAll();

		List<OrderPriceQuantity> orderPriceQuantityList = new ArrayList<OrderPriceQuantity>();

		for (Order ord : orderList) {
			OrderPriceQuantity orderPriceQuantity = new OrderPriceQuantity();
			orderPriceQuantity.setOrder(ord);

			int totalQuantities = ord.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
			orderPriceQuantity.setTotalQuantities(totalQuantities);

			int totalItems = (int) ord.getOrderLine().stream().count();
			orderPriceQuantity.setTotalItems(totalItems);

			double totalPrice = ord.getOrderLine().stream()
					.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();

			orderPriceQuantity.setTotalPrice(totalPrice);

			orderPriceQuantityList.add(orderPriceQuantity);
		}

		model.addAttribute("orderPriceQuantityList", orderPriceQuantityList);
		return "orderList";
	}
	
	@GetMapping("/orders-admin-descrition/{id}")
	public String getOrderDescriptionPage(@PathVariable("id") long id, Model model) {
		Order order = orderService.findById(id);
		
		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("orderDescription", order);
		return "admin-orderDescription";
	}
}
