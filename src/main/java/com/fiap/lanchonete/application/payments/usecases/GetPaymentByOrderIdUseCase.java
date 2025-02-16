package com.fiap.lanchonete.application.payments.usecases;

import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import com.fiap.lanchonete.entities.payments.Payment;

import java.util.Optional;
import java.util.UUID;

public class GetPaymentByOrderIdUseCase {

    private final PaymentGateway paymentGateway;

    public GetPaymentByOrderIdUseCase(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Optional<Payment> getPaymentByOrderId(UUID orderId) {
        return paymentGateway.getPaymentByOrderId(orderId);
    }
}
