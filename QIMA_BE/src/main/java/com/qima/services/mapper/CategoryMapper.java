package com.qima.services.mapper;

import com.qima.dto.CategoryDTO;
import com.qima.entities.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {

    public CategoryDTO toDTO(Category category) {

        if(category == null) {
            return null;
        }
        CategoryDTO dto = new CategoryDTO();
        if(category.getId() != null) {
            dto.setId(category.getId());
        }
        dto.setName(category.getName());
        return dto;
    }

    public Category toEntity(CategoryDTO dto) {
        if(dto == null) {
            return null;
        }
        Category category = new Category();

        if(dto.getId() != null) {
            category.setId(dto.getId());
        }
        category.setName(dto.getName());
        return category;
    }
}