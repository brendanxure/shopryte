package com.xure.xurepify.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CategoryDto {
    private Long id;
    private String catName;
    private Set<ProductDto> catProducts;
}
