package com.mum.edu.ea.webstore.dao;

import com.mum.edu.ea.webstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select p from Product p where p.category like CONCAT('%',:query,'%') " +
            "or p.description like CONCAT('%',:query,'%') or p.manufacturer  like CONCAT('%',:query,'%') " +
            "or p.name like CONCAT('%',:query,'%') order by p.name desc ")
    List<Product> searchProducts(@Param("query") String query);
}
