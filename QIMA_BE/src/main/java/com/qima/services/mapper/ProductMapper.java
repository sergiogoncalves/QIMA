package com.qima.services.mapper;

import com.qima.dto.ProductDTO;
import com.qima.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    CategoryMapper categoryMapper;

    public ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCategory(categoryMapper.toDTO(product.getCategory()));
        dto.setPrice(product.getPrice());
        dto.setAvailable(product.isAvailable());
        return dto;
    }

    public Product toEntity(ProductDTO dto) {
        Product product = new Product();

        if (dto.getId() != null) {
            product.setId(dto.getId());
        }

        product.setName(dto.getName());
        product.setCategory(categoryMapper.toEntity(dto.getCategory()));
        product.setPrice(dto.getPrice());
        product.setAvailable(dto.isAvailable());
        return product;
    }

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
}