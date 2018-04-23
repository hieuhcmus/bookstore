package com.mum.edu.ea.inventory.controller;

import com.mum.edu.ea.inventory.dto.UpdateStatusRequest;
import com.mum.edu.ea.inventory.service.OrderInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.ws.rs.Consumes;

@org.springframework.web.bind.annotation.RestController
@Consumes({MediaType.APPLICATION_JSON_UTF8_VALUE})
public class RestController {
	@Autowired
	private OrderInventoryService orderInventoryService;

	@RequestMapping(value = "/{orderQueueId}/update-status")
	@ResponseStatus(HttpStatus.OK)
	public void updateOrderStatus(@PathVariable("orderQueueId") long orderQueueId, @RequestBody UpdateStatusRequest newStatus) {
		orderInventoryService.processOrder(orderQueueId, newStatus.getNewStatus());
	}
}
