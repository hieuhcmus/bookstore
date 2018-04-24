package com.mum.edu.ea.webstore.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mum.edu.ea.webstore.entity.Order;
import com.mum.edu.ea.webstore.entity.OrderStatus;
import com.mum.edu.ea.webstore.service.OrderLineService;
import com.mum.edu.ea.webstore.service.OrderService;

@Controller
@SessionAttributes(value = "order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderLineService orderLineService;

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
	public String checkoutOrder(Model model, @ModelAttribute("order") Order order, SessionStatus status) {
		order.setOrderStatus(OrderStatus.CONFIRMED);
		orderService.saveOrder(order);
		int totalQuantities = order.getOrderLine().stream().mapToInt(or -> or.getQuantity()).sum();
		double totalPrice = order.getOrderLine().stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();
		model.addAttribute("orderedQuantities", totalQuantities);
		model.addAttribute("totalPrice", totalPrice);
		model.addAttribute("orderDescription", order);
		status.setComplete();
		System.out.println("#######################CALLING........");
		return "orderDescription";
	}
	
	@GetMapping("/orders-admin")
	public String getOrdersListPage(Model model) {
		ArrayList<Order> orderList = (ArrayList<Order>)orderService.findAll();
		
		/*int totalQuantities = orderList.stream().flatMap(orderLine.stream().mapToDouble(anOrderLine => product.getPrice()).sum();
		double totalPrice = oorderList.stream()
				.mapToDouble(orderLine -> orderLine.getQuantity() * orderLine.getProduct().getPrice()).sum();*/
//		model.addAttribute("orderedQuantities", totalQuantities);
//		model.addAttribute("totalPrice", totalPrice);
		
		model.addAttribute("orderList", orderList);
		
		System.out.println("################################################################################# -> "+orderList.get(0).getOrderLine().size());
		return "orderList";
	}
}
