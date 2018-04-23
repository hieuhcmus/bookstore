package com.mum.edu.ea.webstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mum.edu.ea.webstore.entity.OrderLine;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

}
