package com.example.productapp.controller;

import com.example.productapp.model.Product;
import com.example.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/view")
    public ModelAndView viewProducts() {
        List<Product> products = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("product"); // Name of the JSP file without .jsp extension
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateProductForm() {
        return new ModelAndView("product-form"); // Name of the JSP file for the form
    }

    @PostMapping("/create")
    public String createProduct(@RequestParam("name") String name, @RequestParam("price") double price) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        productService.createProduct(product);
        return "redirect:/products/view"; // Redirect to view all products after creation
    }


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        product.setId(id);
        Product updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}



