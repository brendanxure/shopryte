package com.xure.xurepify.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Double price;

    private Category category;
}
