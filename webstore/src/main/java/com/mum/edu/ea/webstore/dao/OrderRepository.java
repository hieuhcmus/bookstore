package com.mum.edu.ea.webstore.dao;

import com.mum.edu.ea.webstore.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.edu.ea.webstore.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findOrderByPerson(Person person);
}
