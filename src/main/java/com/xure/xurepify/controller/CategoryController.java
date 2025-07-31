package com.xure.xurepify.controller;

import com.xure.xurepify.model.Category;
import com.xure.xurepify.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    public List<Category> getAllCategories(){
        categoryService.getAllCategories();
    };
}
