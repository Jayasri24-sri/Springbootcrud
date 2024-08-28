package com.example.productapp.repository;

import com.example.productapp.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface
    ProductRepository extends MongoRepository<Product, String> {
    }


