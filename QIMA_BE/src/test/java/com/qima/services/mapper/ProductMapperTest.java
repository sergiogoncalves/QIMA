package com.qima.services.mapper;

import com.qima.dto.ProductDTO;
import com.qima.entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {

    private ProductMapper productMapper;

    @BeforeEach
    public void setup() {

        CategoryMapper categoryMapper = Mockito.mock(CategoryMapper.class);
        productMapper = new ProductMapper();
        productMapper.setCategoryMapper(categoryMapper);
    }

    @Test
    public void toDTOReturnsCorrectDto() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Electronics");

        ProductDTO productDto = productMapper.toDTO(product);

        assertEquals(product.getId(), productDto.getId());
        assertEquals(product.getName(), productDto.getName());
    }

    @Test
    public void toEntityReturnsCorrectEntity() {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(1L);
        productDto.setName("Electronics");

        Product product = productMapper.toEntity(productDto);

        assertEquals(productDto.getId(), product.getId());
        assertEquals(productDto.getName(), product.getName());
    }
}