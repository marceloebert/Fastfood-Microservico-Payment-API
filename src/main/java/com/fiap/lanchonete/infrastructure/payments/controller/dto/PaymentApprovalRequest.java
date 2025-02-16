package com.fiap.lanchonete.infrastructure.payments.controller.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentApprovalRequest {
    private UUID paymentId;
    private String transactionId;
    private BigDecimal amount;

    // Getters e Setters
    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
