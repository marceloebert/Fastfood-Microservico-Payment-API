package com.fiap.lanchonete.infrastructure.payments.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class CreatePaymentRequest {
    private UUID orderId;
    private BigDecimal amount;

    // Getters e Setters
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
