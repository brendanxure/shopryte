package com.xure.xurepify.controller;

import com.xure.xurepify.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    public List<Category> getAllCategories;
}
