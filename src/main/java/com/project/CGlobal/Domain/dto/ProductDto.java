package com.project.CGlobal.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductDto {
    private String name;
    private BigDecimal price;
    private String brand;
    private String color;
    private Long categoryId;
}
