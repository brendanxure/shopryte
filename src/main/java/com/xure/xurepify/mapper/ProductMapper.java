package com.xure.xurepify.mapper;

import com.xure.xurepify.dto.ProductDto;
import com.xure.xurepify.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mapping(source = "name", target = "prodName")
    @Mapping(source = "description", target = "prodDesc")
    @Mapping(source = "category", target = "categoryDto")
    ProductDto toDto(Product product);

    @Mapping(source = "prodName", target = "name")
    @Mapping(source = "prodDesc", target = "description")
    @Mapping(source = "categoryDto", target = "category")
    Product toEntity(ProductDto productDto);
}
