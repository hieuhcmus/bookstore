package com.mum.edu.ea.webstore.controller;

import com.mum.edu.ea.webstore.entity.Person;
import com.mum.edu.ea.webstore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@Autowired
	private PersonService personService;

	@GetMapping("/person")
	public String createPersonPage(Model model) {
		model.addAttribute("person", new Person());
		return "person";
	}

	@PostMapping("/my-account")
	public String updateAccount(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/my-account";
	}

	@GetMapping("/person/{personId}")
	public String personDetailPage(@PathVariable("personId") Long personId, Model model) {
		model.addAttribute("person", personService.findById(personId));
		return "person";
	}

	@GetMapping("/persons")
	public String personList(Model model) {
		model.addAttribute("persons", personService.findAll());
		return "personList";
	}

	@PostMapping("/person")
	public String createPerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/persons";
	}
}
