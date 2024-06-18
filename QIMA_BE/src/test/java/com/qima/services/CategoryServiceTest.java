package com.qima.services;

import com.qima.entities.Category;
import com.qima.repositories.CategoryRepository;
import com.qima.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getCategoriesReturnsAllCategories() {
        Category category1 = new Category();
        Category category2 = new Category();
        List<Category> expectedCategories = Arrays.asList(category1, category2);

        when(categoryRepository.findAll()).thenReturn(expectedCategories);

        List<Category> actualCategories = categoryService.getCategories();

        assertEquals(expectedCategories, actualCategories);
    }

    @Test
    public void getCategoriesReturnsEmptyList() {
        when(categoryRepository.findAll()).thenReturn(Collections.emptyList());

        List<Category> actualCategories = categoryService.getCategories();

        assertEquals(Collections.emptyList(), actualCategories);
    }
}