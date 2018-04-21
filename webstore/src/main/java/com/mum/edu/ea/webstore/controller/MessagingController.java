package com.mum.edu.ea.webstore.controller;

import com.mum.edu.ea.webstore.jms.Order;
import com.mum.edu.ea.webstore.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingController {
	@Autowired
	private MessagingService messagingService;

	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public void sendMessage(Order order) {
		messagingService.sendMessage(order);
	}
}
