package com.mum.edu.ea.inventory.controller;

import com.mum.edu.ea.inventory.service.OrderQueueService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
