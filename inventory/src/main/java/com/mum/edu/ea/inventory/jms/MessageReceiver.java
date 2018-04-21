package com.mum.edu.ea.inventory.jms;

import com.mum.edu.ea.inventory.service.OrderInventoryService;
import com.mum.edu.ea.inventory.service.OrderQueueService;
import com.mum.edu.ea.jms.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MessageReceiver {

	static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);
	private static final String ORDER_QUEUE = "order-queue";

	@Autowired
	private OrderInventoryService orderInventoryService;

	@Autowired
	private OrderQueueService orderQueueService;

	@JmsListener(destination = ORDER_QUEUE)
	public void receiveMessage(final Message<Order> message) throws JMSException {
		LOG.info("----------------------------------------------------");
		MessageHeaders headers = message.getHeaders();
		LOG.info("Application : headers received : {}", headers);

		Order order = message.getPayload();
		LOG.info("Application : product : {}", order);

//		orderInventoryService.processOrder(order);
		orderQueueService.save(order);
		LOG.info("----------------------------------------------------");
	}
}
