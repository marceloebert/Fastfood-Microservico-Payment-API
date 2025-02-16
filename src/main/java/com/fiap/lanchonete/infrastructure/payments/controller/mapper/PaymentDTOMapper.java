package com.fiap.lanchonete.infrastructure.payments.controller.mapper;

import com.fiap.lanchonete.entities.payments.Payment;
import com.fiap.lanchonete.infrastructure.payments.controller.dto.CreatePaymentRequest;
import com.fiap.lanchonete.infrastructure.payments.controller.dto.PaymentResponse;

public class PaymentDTOMapper {

    public static Payment toDomain(CreatePaymentRequest dto) {
        return new Payment(dto.getOrderId(), dto.getAmount(),null,null,null,null);
    }

    public PaymentResponse toPaymentResponse(Payment payment) {
        PaymentResponse response = new PaymentResponse();
        response.setId(payment.getId());
        response.setOrderId(payment.getOrderId());
        response.setQrCode(payment.getQrCode());
        response.setStatus(payment.getStatus());
        response.setPaymentDate(payment.getPaymentDate());
        response.setAmount(payment.getAmount());
        response.setTransactionId(payment.getTransactionId());
        return response;
    }
}
