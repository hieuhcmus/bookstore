package com.mum.edu.ea.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.ea.webstore.dao.OrderRepository;
import com.mum.edu.ea.webstore.entity.Order;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}
	
	public Order findById(Long id) {
		return orderRepository.findOne(id);
	}
	
	public void removeOrder(Order order) {
		orderRepository.delete(order);
	}
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
}
