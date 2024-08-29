package com.example.productapp.service;

import com.example.productapp.model.Product;
import com.example.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ProductService {

        @Autowired
        private ProductRepository productRepository;

        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }

        public Optional<Product> getProductById(String id) {
            return productRepository.findById(id);
        }

        public Product createProduct(Product product) {
            return productRepository.save(product);
        }

        public Product updateProduct(Product product) {
            return productRepository.save(product);
        }

        public void deleteProduct(String id) {
            productRepository.deleteById(id);
        }
    }


