package com.mum.edu.ea.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mum.edu.ea.webstore.dao.OrderLineRepository;
import com.mum.edu.ea.webstore.entity.OrderLine;

@Service
public class OrderLineService {

	@Autowired
	private OrderLineRepository orderLineRepository;
	
	public void saveOrderLine(OrderLine orderLine) {
		orderLineRepository.save(orderLine);
	}
	
	public OrderLine findById(Long id) {
		return orderLineRepository.findOne(id);
	}
	
	public void removeOrderLine(OrderLine orderLine) {
		orderLineRepository.delete(orderLine);
	}
	
	public List<OrderLine> findAll(){
		return orderLineRepository.findAll();
	}
}
