package com.example.projecttdd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.projecttdd.model.Product;

@Service
public class ProductService {

    public List<Product> getAll() {

        List<Product> products = new ArrayList<Product>();

        return products;
    }

    public Optional<Product> getById(Long id) {

        Optional<Product> product = Optional.of(new Product());

        return product;
    }

    public Product addProduct(Product product) {

        return product;
    }

}
