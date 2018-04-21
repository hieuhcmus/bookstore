package com.mum.edu.ea.inventory.dao;

import com.mum.edu.ea.inventory.entity.OrderQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderQueueRepository extends JpaRepository<OrderQueue, Long> {
}
