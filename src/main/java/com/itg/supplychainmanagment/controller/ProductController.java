package com.itg.supplychainmanagment.controller;

import com.itg.supplychainmanagment.entity.Product;
import com.itg.supplychainmanagment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product viewProductDetails(@PathVariable Long id) {
        return productService.viewProductDetails(id);
    }

    @GetMapping("/search/{name}")
    public Product searchByProductName(@PathVariable String name) {
        return productService.searchByProductName(name);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // TODO: check this method and relative rep/service parts
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}