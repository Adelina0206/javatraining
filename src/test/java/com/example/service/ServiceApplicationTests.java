package com.example.service;

import com.example.service.entities.Product;
import com.example.service.repositories.ProductRepository;
import com.example.service.services.ProductServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ServiceApplicationTests {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServices productServices;

    @Test
    void getProductPriceTest() {
        List <Product> result = new ArrayList<>();
        Product p1 = new Product ();
        p1.setName("Beer");
        p1.setPrice(10);

        Product p2 = new Product ();
        p2.setName("Chocolate");
        p2.setPrice(15);

        result.add(p1);
        result.add(p2);

        given(productRepository.findAll()).willReturn (result);

       List<Product> products = productServices.getProductsByPrice(11);

       for (Product p : products) {
           assertTrue(p.getPrice() > 11);
       }
    }


}
