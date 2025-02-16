package com.fiap.lanchonete.infrastructure.products.controller.dto;

import com.fiap.lanchonete.entities.products.enums.Category;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponse {

    private UUID id;
    private String description;
    private BigDecimal price;
    private Category category;

    public ProductResponse() {
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

