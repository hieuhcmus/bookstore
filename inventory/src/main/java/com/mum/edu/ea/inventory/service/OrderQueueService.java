package com.mum.edu.ea.inventory.service;

import com.mum.edu.ea.inventory.dao.OrderQueueRepository;
import com.mum.edu.ea.inventory.entity.OrderQueue;
import com.mum.edu.ea.jms.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderQueueService {
	@Autowired
	private OrderQueueRepository orderQueueRepository;

	public void save(Order order) {
		OrderQueue orderQueue = new OrderQueue();
		orderQueue.setName(order.getName());
		orderQueue.setDescription(order.getDescription());
		orderQueue.setStatus(order.getStatus());
		orderQueue.setQuantity(order.getQuantity());
		orderQueue.setTotalPrice(order.getTotalPrice());
		orderQueue.setCreatedDate(new Date());
		orderQueue.setOrderId(order.getOrderId());
		orderQueueRepository.save(orderQueue);
	}

	public List<OrderQueue> getAll() {
		return orderQueueRepository.findAll();
	}
}
