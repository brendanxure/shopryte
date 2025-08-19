package com.xure.xurepify.dto;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String prodName;
    private String prodDesc;
    private String imageUrl;
}
