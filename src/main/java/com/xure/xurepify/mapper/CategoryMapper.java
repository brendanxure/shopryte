package com.xure.xurepify.mapper;

import com.xure.xurepify.dto.CategoryDto;
import com.xure.xurepify.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // Entity -> DTO
    @Mapping(target = "catName", source = "name")
    @Mapping(target = "catProducts", source = "products")
    CategoryDto toDto(Category category);

    // DTO -> Entity
    @Mapping(target = "name", source = "catName")
    @Mapping(target = "products", source = "catProducts")
    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryDto category);
}

