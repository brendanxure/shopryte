package com.xure.xurepify.repository;

import com.xure.xurepify.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product>  findByCategoryId(Long categoryId);
}
