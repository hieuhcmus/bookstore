package com.mum.edu.ea.webstore.controller;

import com.mum.edu.ea.webstore.entity.Person;
import com.mum.edu.ea.webstore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@Autowired
	private PersonService personService;

	@GetMapping({"/"})
	public String homePage(Model model) {
		return "index";
	}

	@GetMapping({"/login"})
	public String loginPage() {
		return "login";
	}

	@GetMapping({"/signup"})
	public String signupPage(Model model) {
		model.addAttribute("person", new Person());
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(@ModelAttribute Person person) {
		personService.signup(person);
		return "redirect:/login";
	}
}
