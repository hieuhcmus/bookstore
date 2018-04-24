package com.mum.edu.ea.webstore.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MEmailServiceImpl implements MEmailService {

	@Autowired
	JavaMailSender emailSender;
	
	@Override
	public void sendEmailNotification(String to, String messageHeading, String messageBody) {
		System.out.println("#############EMAIL NOTIFICATION CALLED");
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(messageHeading);
		simpleMailMessage.setText(messageBody);
		emailSender.send(simpleMailMessage);		
		System.out.println("#############EMAIL NOTIFICATION SENT");
		}

}
