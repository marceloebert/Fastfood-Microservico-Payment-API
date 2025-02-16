package com.fiap.lanchonete.application.payments.gateways;

import com.fiap.lanchonete.entities.payments.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentGateway {
    Payment save(Payment payment);

    Optional<Payment> GetPaymentById(UUID id);

    Optional<Payment> getPaymentByOrderId(UUID orderId);
}
