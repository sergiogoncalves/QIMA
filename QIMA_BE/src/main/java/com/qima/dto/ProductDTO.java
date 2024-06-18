package com.qima.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private CategoryDTO category;
    private double price;
    private boolean available;

}