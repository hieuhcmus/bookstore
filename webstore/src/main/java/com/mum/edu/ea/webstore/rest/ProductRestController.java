package com.mum.edu.ea.webstore.rest;

import com.mum.edu.ea.webstore.entity.Product;
import com.mum.edu.ea.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/all")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping(path = "/search")
    public List<Product> searchProduct(String query){
        return productService.searchProduct(query);
    }

    @GetMapping(path = "/{productId}")
    public Product getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping(path = "/addProduct")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PostMapping(path = "/updateProduct")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @PostMapping(path = "/delete/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}
