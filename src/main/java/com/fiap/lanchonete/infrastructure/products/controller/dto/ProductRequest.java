package com.fiap.lanchonete.infrastructure.products.controller.dto;

import java.math.BigDecimal;

public class ProductRequest {
    private String description;
    private BigDecimal price;
    private String category;

    // Getters e Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

