package com.mum.edu.ea.webstore.controller;

import com.mum.edu.ea.webstore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private PersonService personService;

	@GetMapping({"/"})
	public String homePage(Model model) {
		return "login";
	}

	@GetMapping({"/login"})
	public String securePage() {
		return "login";
	}
}
