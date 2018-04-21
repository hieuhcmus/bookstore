package com.mum.edu.ea.webstore.service;

import com.mum.edu.ea.jms.model.InventoryResponse;
import com.mum.edu.ea.webstore.jms.MessageSender;
import com.mum.edu.ea.jms.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {
	static final Logger LOG = LoggerFactory.getLogger(MessagingService.class);

	@Autowired
	private MessageSender messageSender;

	public void sendMessage(Order order) {
		LOG.info("Sending JMS message {}", order);
		messageSender.sendMessage(order);
	}

	public void updateOrderStatus(InventoryResponse response) {
		//TODO
	}
}
