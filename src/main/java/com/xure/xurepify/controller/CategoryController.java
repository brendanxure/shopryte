package com.xure.xurepify.controller;

import com.xure.xurepify.dto.CategoryDto;
import com.xure.xurepify.dto.ProductDto;
import com.xure.xurepify.mapper.CategoryMapper;
import com.xure.xurepify.model.Category;
import com.xure.xurepify.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> response;
        response = categoryService.getAllCategories().stream().map(categoryMapper::toDto).toList();
        return ResponseEntity.ok(response);
    };

    @PostMapping
    public ResponseEntity<CategoryDto> createCategories(@RequestBody CategoryDto categoryDto){
        categoryDto.setId(null);

        Category category = categoryMapper.toEntity(categoryDto);
        return ResponseEntity.ok(categoryDto);
    };
}
