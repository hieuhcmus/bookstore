package com.mum.edu.ea.inventory.dao;

import com.mum.edu.ea.inventory.entity.OrderQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderQueueRepository extends JpaRepository<OrderQueue, Long> {
	List<OrderQueue> findByStatusIn(List<String> statusList);
}
