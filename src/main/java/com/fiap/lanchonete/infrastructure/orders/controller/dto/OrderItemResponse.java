package com.fiap.lanchonete.infrastructure.orders.controller.dto;

import com.fiap.lanchonete.infrastructure.products.controller.dto.ProductResponse;
import java.math.BigDecimal;
import java.util.UUID;

public class OrderItemResponse {

    private UUID id;
    private ProductResponse product;
    private int quantity;
    private String observation;
    private BigDecimal totalPrice;

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductResponse getProduct() {
        return product;
    }

    public void setProduct(ProductResponse product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
