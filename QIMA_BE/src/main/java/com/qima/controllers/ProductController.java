package com.qima.controllers;

import com.qima.dto.ProductDTO;
import com.qima.repositories.ProductRepository;
import com.qima.services.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElse(null);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(productDTO)));
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setId(id);
        return productMapper.toDTO(productRepository.save(productMapper.toEntity(productDTO)));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productRepository.deleteById(id);
    }
}