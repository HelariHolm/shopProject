package com.example.shopproject.controllers;


import com.example.shopproject.entities.Product;
import com.example.shopproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@ResponseBody
public class ProductController {

    @Autowired
    public ProductRepository productRepository;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/product")
    public Product createProduct(@Validated @RequestBody Product product) {
        Product createProduct = new Product();
        createProduct.setDescription(product.getDescription());
        createProduct.setPrice(product.getPrice());
        createProduct.setQuantity(product.getQuantity());
        return productRepository.save(product);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable(value = "id") Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    @GetMapping("/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productToUpdate)  {
        Product foundProduct = productRepository.findById(id).orElseThrow();
        foundProduct.setDescription(productToUpdate.getDescription());
        foundProduct.setPrice(productToUpdate.getPrice());

        return productRepository.save(foundProduct);
    }





}
