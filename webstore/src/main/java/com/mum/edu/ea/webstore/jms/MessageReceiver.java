package com.mum.edu.ea.webstore.jms;

import com.mum.edu.ea.jms.model.InventoryResponse;
import com.mum.edu.ea.webstore.service.MessagingService;
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

	private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

	@Autowired
	private MessagingService messagingService;

	@JmsListener(destination = ORDER_RESPONSE_QUEUE)
	public void receiveMessage(final Message<InventoryResponse> message) throws JMSException {
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		MessageHeaders headers = message.getHeaders();
		LOG.info("Application : headers received : {}", headers);

		InventoryResponse response = message.getPayload();
		LOG.info("Application : response received : {}", response);

		messagingService.updateOrderStatus(response);
		LOG.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
