package com.itg.supplychainmanagment.service;

import com.itg.supplychainmanagment.entity.Product;
import com.itg.supplychainmanagment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    public Product searchByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getFiveProducts(){
        List<Product> allProducts = productRepository.findAll();
        int totalProducts = allProducts.size();
        if (totalProducts > 5) {
            return allProducts.subList(totalProducts - 5, totalProducts);
        }
        return allProducts;
    }

    public Product viewProductDetails(long productId) {
        return productRepository.findById(productId).get();
    }
    public Product updateProduct(Long productId, Product product) {
        Product existingProduct = productRepository.findById(productId).orElse(null);
        if(existingProduct != null) {
            existingProduct.setProductName(product.getProductName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setProductPrice(product.getProductPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}