package com.mum.edu.ea.webstore.dao;

import com.mum.edu.ea.webstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
