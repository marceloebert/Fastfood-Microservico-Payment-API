package com.fiap.lanchonete.application.payments.usecases;

import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import com.fiap.lanchonete.entities.payments.Payment;

import java.util.Optional;
import java.util.UUID;

public class GetPaymentByIdUseCase {

    private final PaymentGateway paymentGateway;

    public GetPaymentByIdUseCase(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Optional<Payment> GetPaymentById(UUID id) {

        return paymentGateway.GetPaymentById(id);
    }
}
