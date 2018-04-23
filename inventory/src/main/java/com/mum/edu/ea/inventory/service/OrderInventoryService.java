package com.mum.edu.ea.inventory.service;

import com.mum.edu.ea.inventory.dao.OrderQueueRepository;
import com.mum.edu.ea.inventory.entity.OrderQueue;
import com.mum.edu.ea.jms.model.InventoryResponse;
import com.mum.edu.ea.inventory.jms.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderInventoryService {
	static final Logger LOG = LoggerFactory.getLogger(OrderInventoryService.class);

	@Autowired
	private MessageSender messageSender;

	@Autowired
	private OrderQueueRepository orderQueueRepository;

	public void processOrder(long orderQueueId, String status) {
		Optional<OrderQueue> orderQueueOpt = orderQueueRepository.findById(orderQueueId);
		OrderQueue orderQueue = orderQueueOpt.get();
		orderQueue.setStatus(status);
		orderQueueRepository.save(orderQueue);
		InventoryResponse response = prepareResponse(orderQueue, status);
		LOG.info("Inventory : sending order confirmation {}", response);
		messageSender.sendMessage(response);
	}

	private InventoryResponse prepareResponse(OrderQueue orderQueue, String status) {
		InventoryResponse response = new InventoryResponse();
		response.setId(orderQueue.getOrderId());
		response.setStatus(status);
		return response;
	}


}
