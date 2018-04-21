package com.mum.edu.ea.inventory.service;

import com.mum.edu.ea.jms.model.InventoryResponse;
import com.mum.edu.ea.inventory.jms.MessageSender;
import com.mum.edu.ea.jms.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInventoryService {
	static final Logger LOG = LoggerFactory.getLogger(OrderInventoryService.class);

	@Autowired
	private MessageSender messageSender;

	public void processOrder(Order order) {
		InventoryResponse response = prepareResponse(order);
		LOG.info("Inventory : sending order confirmation {}", response);
		messageSender.sendMessage(response);
	}

	private InventoryResponse prepareResponse(Order order) {
		InventoryResponse response = new InventoryResponse();
		response.setOrderName(order.getName());
//		response.setReturnCode(200);
//		response.setComment("Order Processed successfully");
		return response;
	}


}
