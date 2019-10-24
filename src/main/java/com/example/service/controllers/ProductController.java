package com.example.service.controllers;

import com.example.service.entities.Product;
import com.example.service.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServices productService;

    @PostMapping("/product/add")
    public void addProduct(@RequestBody Product p) {
        productService.addProduct(p);
    }

    @GetMapping("/product/all")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @GetMapping ("/product/price")
    public List<Product> getProductsByPrice(@RequestBody Product p) {
        return productService.getProductsByPrice(p.getPrice());
    }
}

