package com.qima.services;

import com.qima.dto.ProductDTO;
import com.qima.entities.Product;
import com.qima.repositories.ProductRepository;
import com.qima.services.mapper.ProductMapper;
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

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getProductsReturnsAllProducts() {
        Product product1 = new Product();
        Product product2 = new Product();
        List<Product> products = Arrays.asList(product1, product2);

        ProductDTO productDTO1 = new ProductDTO();
        ProductDTO productDTO2 = new ProductDTO();
        List<ProductDTO> expectedProducts = Arrays.asList(productDTO1, productDTO2);

        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.toDTO(product1)).thenReturn(productDTO1);
        when(productMapper.toDTO(product2)).thenReturn(productDTO2);

        List<ProductDTO> actualProducts = productService.getAllProducts();

        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    public void getProductsReturnsEmptyList() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<ProductDTO> actualProducts = productService.getAllProducts();

        assertEquals(Collections.emptyList(), actualProducts);
    }
}