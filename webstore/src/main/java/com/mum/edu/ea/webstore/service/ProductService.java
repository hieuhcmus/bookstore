package com.mum.edu.ea.webstore.service;

import com.mum.edu.ea.webstore.dao.ProductRepository;
import com.mum.edu.ea.webstore.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProduct(@RequestParam("productId") Long productId){
        return productRepository.findOne(productId);
    }

    public List<Product> searchProduct(String query){
        return productRepository.searchProducts(query);
    }

    public void addProduct(Product product){
        productRepository.saveAndFlush(product);
    }

    public void updateProduct(Product product){
        productRepository.saveAndFlush(product);
    }

    public void deleteProduct(Long productId){
        productRepository.delete(productId);
    }
}
