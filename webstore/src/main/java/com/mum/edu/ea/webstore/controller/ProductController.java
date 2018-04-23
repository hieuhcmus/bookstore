package com.mum.edu.ea.webstore.controller;

import com.mum.edu.ea.webstore.entity.Order;
import com.mum.edu.ea.webstore.entity.OrderLine;
import com.mum.edu.ea.webstore.entity.Product;
import com.mum.edu.ea.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
@SessionAttributes(value = {"order"})
public class ProductController {

    @ModelAttribute("order")
    public Order getOrder(){
        return new Order();
    }

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/all")
    public String getProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "productList";
    }

    @PostMapping(path = "/all")
    public String searchProduct(Model model, @RequestParam("query") String query){
        model.addAttribute("products", productService.searchProduct(query));
        return "productList";
    }

    @GetMapping(path = "/{productId}")
    public String getProduct(Model model, @PathVariable Long productId){
        model.addAttribute("product", productService.getProduct(productId));
        return "editProduct";
    }

    @GetMapping(path = "/addProduct")
    public String addProductPage(Model model){
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping(path = "/addProduct")
    public String addProduct(Product product){
        productService.addProduct(product);
        return "redirect:/product/all";
    }

    @PostMapping(path = "/updateProduct")
    public String updateProduct(Product product){
        productService.updateProduct(product);
        return "redirect:/product/all";
    }

    @PostMapping(path = "/delete/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return "redirect:/product/all";
    }

    @GetMapping(path = "/productDetails/{productId}")
    public String productDetailsPage(Model model, @PathVariable Long productId){
        OrderLine orderLine = new OrderLine();
        orderLine.setQuantity(1);
        orderLine.setProduct(productService.getProduct(productId));
        model.addAttribute("orderline", orderLine);
        return "productDetails";
    }

    @PostMapping(path = "/addToCart/{productId}")
    public String productDetails(Model model, @ModelAttribute("order") Order order,
                                 @RequestParam("quantity") int quantity, @PathVariable Long productId){
        List<OrderLine> orderLines = order.getOrderLine();
        Boolean orderLineExists = false;
        for(OrderLine orderLine : orderLines){
            if(orderLine.getProduct().getId() == productId){
                orderLine.setQuantity(quantity);
                orderLineExists = true;
            }
        }
        if(!orderLineExists){
            OrderLine orderLine = new OrderLine();
            orderLine.setProduct(productService.getProduct(productId));
            orderLine.setQuantity(quantity);
            orderLine.setCreatedAt(new Date());
            orderLine.setUpdatedAt(new Date());
            orderLines.add(orderLine);
            order.setOrderLine(orderLines);
        }
        return "redirect:/product/all";
    }
}
