package com.example.projecttdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
   
    
    @Test
public void should_calculate_total_product_value(){

Product product = new Product();
product.setAmount(10);
product.setDiscount(10.0);
product.setAdditional(0.0);
product.setValue(10.0);

Double expectedResult = 90.0;

Double result = product.calculateTotalValue();

Assertions.assertEquals(expectedResult, result);

}
}
