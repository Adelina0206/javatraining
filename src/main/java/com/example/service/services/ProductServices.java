package com.example.service.services;

import com.example.service.entities.Product;
import com.example.service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product p) {
        productRepository.save(p);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByPrice(double price) {

        List<Product> result = new ArrayList<>();
        List<Product> products = productRepository.findAll();

        for (Product p : products) {
            if (p.getPrice() > price) {
                result.add(p);
            }
        }
        return result;
    }
}

