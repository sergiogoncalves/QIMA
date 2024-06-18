package com.qima.controllers;
import com.qima.controllers.ProductController;
import com.qima.dto.ProductDTO;
import com.qima.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllProductsReturnsAllProducts() {
        ProductDTO productDTO1 = new ProductDTO();
        ProductDTO productDTO2 = new ProductDTO();
        List<ProductDTO> expectedProducts = Arrays.asList(productDTO1, productDTO2);

        when(productService.getAllProducts()).thenReturn(expectedProducts);

        ResponseEntity<List<ProductDTO>> response = ResponseEntity.ok(productController.getAllProducts());

        assertEquals(expectedProducts, response.getBody());
    }

    @Test
    public void getAllProductsReturnsEmptyListWhenNoProducts() {
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        ResponseEntity<List<ProductDTO>> response = ResponseEntity.ok(productController.getAllProducts());

        assertEquals(Collections.emptyList(), response.getBody());
    }
}