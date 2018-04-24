package com.mum.edu.ea.webstore.dao;


import com.mum.edu.ea.webstore.entity.Payment;
import com.mum.edu.ea.webstore.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	List<Payment> findAllByFirstName(String CARD_NO);
}
