package com.xure.xurepify.dto;

import com.xure.xurepify.model.Product;
import lombok.Data;

import java.util.Set;

@Data
public class Category {
    private Long id;
    private String catName;
    private Set<Product> catProducts;
}
