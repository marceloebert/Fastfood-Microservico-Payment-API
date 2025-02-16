package com.fiap.lanchonete.entities.orders;

import com.fiap.lanchonete.entities.products.Product;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {

    private UUID id;
    private Product product;
    private UUID productId;
    private int quantity;
    private String observation;
    private BigDecimal totalPrice;

    public OrderItem(UUID id, UUID productId, int quantity, String observation) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.observation = observation;
        this.totalPrice = calculateTotalPrice();
    }

    public OrderItem(UUID productId, int quantity, String observation) {
        this.productId = productId;
        this.quantity = quantity;
        this.observation = observation;
        this.totalPrice = calculateTotalPrice();
    }

    public OrderItem(UUID id, Product product, int quantity, String observation) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.observation = observation;
        this.totalPrice = calculateTotalPrice();
    }

    public UUID getId() {
        return id;
    }

    public UUID getProductId() {
        return productId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getObservation() {
        return observation;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    private BigDecimal calculateTotalPrice() {
        if (product != null) {
            return product.getPrice().multiply(BigDecimal.valueOf(quantity));
        } else {
            return BigDecimal.ZERO;
        }
    }

    public void setProduct(Product product) {
        this.product = product;
        this.totalPrice = calculateTotalPrice();
    }
}
