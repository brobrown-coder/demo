package com.example.demo.product.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductVO {
    private String index; // Index
    private String name; // Name
    private String description; // Description
    private String brand; // Brand
    private String category; // Category
    private String price; // Price
    private String currency; // Currency
    private String stock; // Stock
    private String ean; // EAN
    private String color; // Color
    private String size; // Size
    private String availability; // Availability
    private String internalId; // Internal ID
}
