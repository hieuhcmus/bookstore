package com.mum.edu.ea.webstore.advice;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.edu.ea.webstore.config.UserAdapter;
import com.mum.edu.ea.webstore.entity.Person;
import com.mum.edu.ea.webstore.service.PersonService;
import com.mum.edu.ea.webstore.util.MEmailService;
import org.springframework.security.core.Authentication;

@Aspect
@Component
public class EmailAdvisor {

	@Autowired
	MEmailService emailService;

	@Autowired
	PersonService personService;
	
	@After("execution(* com.mum.edu.ea.webstore.controller.OrderController.checkoutOrder(..))")
	public void traceMethod(JoinPoint joinPoint, Authentication authentication) {

		UserAdapter userAdapter = (UserAdapter) authentication.getPrincipal();
		List<Person> persons = personService.findByEmail(userAdapter.getUser().getEmail());
		String email = persons.get(0).getEmail();
		
		
		
		emailService.sendEmailNotification(email, "Your Order Has Been Confirmed", "Hello from webstore, We have confirmed your order and It is being processed");

	}

}
