package com.mum.edu.ea.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mum.edu.ea.webstore.entity.Order;
import com.mum.edu.ea.webstore.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/shopping-cart")
	public String createOrderPage(Model model) {
		model.addAttribute("shoppingCart", new Order());
		return "shoppingCart";
	}
	
	@PostMapping("/order")
	public String createOrder(Order order) {
		orderService.saveOrder(order);
		return "redirect:/";
	}
}
