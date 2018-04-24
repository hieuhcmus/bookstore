package com.mum.edu.ea.webstore.controller;

import com.mum.edu.ea.webstore.entity.Payment;
import com.mum.edu.ea.webstore.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {
	/*@Autowired
	private PersonService personService;
	*/

	@GetMapping("/payment/status")
	public String getPaymentStatus() {
		System.out.println("payment_status");
		return "payment";
	}
	@PostMapping("/post-payment")
	public String postPayment(@ModelAttribute("payment") Payment payment) {
		//personService.savePerson(person);
		System.out.println(payment.toString());
		return "payment_status";
	}
}
