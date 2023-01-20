package com.itg.supplychainmanagment.repository;

import com.itg.supplychainmanagment.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);
}