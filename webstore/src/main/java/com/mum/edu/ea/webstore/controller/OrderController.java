package com.mum.edu.ea.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mum.edu.ea.webstore.entity.Order;
import com.mum.edu.ea.webstore.service.OrderService;

@Controller
@SessionAttributes(value = "order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/shopping-cart")
	public String createOrderPage(Model model, @ModelAttribute("order") Order order) {
		
//		System.out.println(order.getOrderLine().size());
		
		model.addAttribute("ShoppingCart", order);
		return "shoppingCart";
	}
	
	@PostMapping("/order")
	public String createOrder(Order order) {
		orderService.saveOrder(order);
		return "redirect:/";
	}
}
