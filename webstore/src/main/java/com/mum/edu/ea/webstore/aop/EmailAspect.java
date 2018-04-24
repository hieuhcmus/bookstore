package com.mum.edu.ea.webstore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mum.edu.ea.webstore.util.MEmailService;

@Aspect
@Component
public class EmailAspect {
	
	@Autowired
	MEmailService emailService;
	
	@After("execution(* com.mum.edu.ea.webstore.controller.OrderController.checkoutOrder(..))")
	public void traceMethod(JoinPoint joinPoint) {
		System.out.println("############TRACE CALLED!!!!!!!!!!!!!!!");
		emailService.sendEmailNotification("mafrelkc@gmail.com", "test", "Hello from webstore");
		
	}
	
}
