package com.mum.edu.ea.inventory.controller;

import com.mum.edu.ea.inventory.service.OrderQueueService;
import com.mum.edu.ea.jms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {
	@Autowired
	private OrderQueueService orderQueueService;

	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String prepareProduct(Model model) {
		model.addAttribute("orders", orderQueueService.getAll());
		return "index";
	}

	@SendTo("/topic/new-order")
	@MessageMapping("/new-order")
	public Order onNewOrder(Order order) {
		return order;
	}
}
