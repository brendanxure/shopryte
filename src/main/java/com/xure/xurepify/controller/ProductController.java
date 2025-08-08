package com.xure.xurepify.controller;

import com.xure.xurepify.model.Product;
import com.xure.xurepify.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductByCategoryId(@PathVariable Long categoryId) {
        return productService.getProductByCategory(categoryId);
    }
}
