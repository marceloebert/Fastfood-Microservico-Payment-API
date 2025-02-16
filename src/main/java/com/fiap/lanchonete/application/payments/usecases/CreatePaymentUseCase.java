package com.fiap.lanchonete.application.payments.usecases;

import com.fiap.lanchonete.entities.payments.Payment;
import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import com.fiap.lanchonete.entities.payments.enums.PaymentStatus;

import java.util.UUID;

public class CreatePaymentUseCase {

    private final PaymentGateway paymentGateway;

    public CreatePaymentUseCase(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Payment createPayment(Payment payment) {

        payment.setQrCode("SimulatedQRCode_" + UUID.randomUUID());
        payment.setStatus(PaymentStatus.PENDING);
        return paymentGateway.save(payment);
    }
}
