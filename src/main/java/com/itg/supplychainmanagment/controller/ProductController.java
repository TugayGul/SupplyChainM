package com.itg.supplychainmanagment.controller;

import com.itg.supplychainmanagment.entity.Product;
import com.itg.supplychainmanagment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasAnyRole('ROLE_RETAILER','ROLE_SUPPLIER')")
    @GetMapping("/{id}")
    public Product viewProductDetails(@PathVariable Long id) {
        return productService.viewProductDetails(id);
    }


    @PreAuthorize("hasAnyRole('ROLE_RETAILER','ROLE_SUPPLIER')")
    @GetMapping("/search/{name}")
    public Product searchByProductName(@PathVariable String name) {
        return productService.searchByProductName(name);
    }



    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/lastFiveProducts")
    public ModelAndView getFiveProducts() {
        List<Product> products = productService.getFiveProducts();
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("products", products);
        return mav;
    }


    @PreAuthorize(value = "hasRole('ROLE_SUPPLIER')")
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }


    // TODO: check this method and relative rep/service parts
    @PreAuthorize(value = "hasRole('ROLE_SUPPLIER')")
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product product) {
        return productService.updateProduct(productId, product);
    }


    @PreAuthorize(value = "hasRole('ROLE_SUPPLIER')")
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}