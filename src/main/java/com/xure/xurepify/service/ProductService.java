package com.xure.xurepify.service;

import com.xure.xurepify.model.Category;
import com.xure.xurepify.model.Product;
import com.xure.xurepify.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long id) {
        return productRepository.findByCategoryId(id);
    }

    public Product postProduct(Product product) {
        return productRepository.save(product);
    }
}
