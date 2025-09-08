package com.xure.xurepify.controller;

import com.xure.xurepify.dto.CategoryDto;
import com.xure.xurepify.dto.ProductDto;
import com.xure.xurepify.mapper.ProductMapper;
import com.xure.xurepify.model.Category;
import com.xure.xurepify.model.Product;
import com.xure.xurepify.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> response = productService.getAllProducts().stream().map(productMapper::toDto).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/category/{categoryId}")
    public  ResponseEntity<List<ProductDto>> getProductByCategoryId(@PathVariable Long categoryId) {
        List<ProductDto> response = productService.getProductByCategory(categoryId).stream().map(productMapper::toDto).toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        productDto.setId(null);

        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productService.postProduct(product);

    };
}
