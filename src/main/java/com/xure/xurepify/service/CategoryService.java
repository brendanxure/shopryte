package com.xure.xurepify.service;

import com.xure.xurepify.dto.CategoryDto;
import com.xure.xurepify.model.Category;
import com.xure.xurepify.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category postCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found with id " + categoryId));
    }
}
