package com.mum.edu.ea.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String prepareProduct(ModelMap model) {
		return "index";
	}
}
