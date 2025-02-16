package com.fiap.lanchonete.entities.payments;
import com.fiap.lanchonete.entities.payments.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private UUID id;
    private UUID orderId;
    private String qrCode;
    private PaymentStatus status;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
    private String transactionId;

    public Payment(UUID orderId, BigDecimal amount, String qrCode, PaymentStatus status, LocalDateTime paymentDate, String transactionId) {
        this.orderId = orderId;
        this.amount = amount;
        this.qrCode = qrCode;
        this.status = status;
        this.transactionId = transactionId;
        this.paymentDate = paymentDate;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setLocalDateTime(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount ) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void approve(String transactionId) {
        this.status = PaymentStatus.APPROVED;
        this.paymentDate = LocalDateTime.now();
        this.transactionId = transactionId;
    }

    public boolean isPending() {
        return this.status == PaymentStatus.PENDING;
    }
}
