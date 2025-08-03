package com.xure.xurepify.config;

import com.xure.xurepify.model.Category;
import com.xure.xurepify.model.Product;
import com.xure.xurepify.repository.CategoryRepository;
import com.xure.xurepify.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        // Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        // Categories
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, clothing, home));

        // Create Products
        Product phone = new Product();
        phone.setName("Smartphones");
        phone.setDescription("Latest phone with good features");
        phone.setImageUrl("");
        phone.setPrice(200.00);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("Laptop product with high performance");
        laptop.setImageUrl("");
        laptop.setPrice(490.90);
        laptop.setCategory(electronics);

        Product laptop1 = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("Laptop product with high performance");
        laptop.setImageUrl("");
        laptop.setPrice(490.90);
        laptop.setCategory(electronics);
    }
}
