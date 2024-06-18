package com.qima.services.mapper;

import com.qima.dto.CategoryDTO;
import com.qima.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryMapperTest {

    private CategoryMapper categoryMapper;

    @BeforeEach
    public void setup() {
        categoryMapper = new CategoryMapper();
    }

    @Test
    public void toDTOReturnsCorrectDto() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Electronics");

        CategoryDTO categoryDto = categoryMapper.toDTO(category);

        assertEquals(category.getId(), categoryDto.getId());
        assertEquals(category.getName(), categoryDto.getName());
    }

    @Test
    public void toEntityReturnsCorrectEntity() {
        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setId(1L);
        categoryDto.setName("Electronics");

        Category category = categoryMapper.toEntity(categoryDto);

        assertEquals(categoryDto.getId(), category.getId());
        assertEquals(categoryDto.getName(), category.getName());
    }
}