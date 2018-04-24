package com.mum.edu.ea.webstore.service;

import com.mum.edu.ea.webstore.dao.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	/*public Payment findById(Long id) {
		return paymentRepository.getOne(id);
	}

	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	public void save(Payment payment) {
		payment.setEnabled(true);

		paymentRepository.save(payment);
	}*/
}
