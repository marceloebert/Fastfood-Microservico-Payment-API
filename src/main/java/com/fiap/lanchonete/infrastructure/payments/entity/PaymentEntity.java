package com.fiap.lanchonete.infrastructure.payments.entity;

import com.fiap.lanchonete.entities.payments.Payment;
import com.fiap.lanchonete.entities.payments.enums.PaymentStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = true)
    private LocalDateTime paymentDate;

    @Column(nullable = true)
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    @Column(nullable = false)
    private String qrCode;


    public PaymentEntity() {}

        public PaymentEntity(Payment payment) {
        this.id = payment.getId();
        this.orderId = payment.getOrderId();
        this.amount = payment.getAmount();
        this.paymentDate = payment.getPaymentDate();
        this.transactionId = payment.getTransactionId();
        this.paymentStatus = payment.getStatus();
        this.qrCode = payment.getQrCode();
    }


    public Payment toPayment() {
        Payment payment = new Payment(this.orderId, this.amount,this.qrCode,this.paymentStatus,this.paymentDate,this.transactionId);
        payment.setId(this.id);

        if (this.paymentStatus == PaymentStatus.APPROVED) {
            payment.approve(this.transactionId);
        }
        return payment;
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

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
}
