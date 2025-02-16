package com.fiap.lanchonete.infrastructure.orders.controller.dto;

import com.fiap.lanchonete.entities.products.Product;

import java.util.UUID;

public class OrderItemRequest {


    private UUID productId;
    private int quantity;
    private String observation;
    private Product product;


    public UUID getProductId() {
        return productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
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
}
