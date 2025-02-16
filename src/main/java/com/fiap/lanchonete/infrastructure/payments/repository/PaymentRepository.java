package com.fiap.lanchonete.infrastructure.payments.repository;

import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import com.fiap.lanchonete.entities.payments.Payment;
import com.fiap.lanchonete.infrastructure.payments.entity.PaymentEntity;
import org.springframework.stereotype.Component;


import java.util.Optional;
import java.util.UUID;

@Component
public class PaymentRepository implements PaymentGateway {

    private final JpaPaymentRepository paymentJpaRepository;

    public PaymentRepository(JpaPaymentRepository jpaPaymentRepository) {
        this.paymentJpaRepository = jpaPaymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity(payment);
        PaymentEntity savedEntity = paymentJpaRepository.save(paymentEntity);
        return savedEntity.toPayment();
    }

    @Override
    public Optional<Payment> GetPaymentById(UUID id) {
        return paymentJpaRepository.findById(id).map(PaymentEntity::toPayment);
    }

    @Override
    public Optional<Payment> getPaymentByOrderId(UUID orderId) {
        return paymentJpaRepository.findByOrderId(orderId).map(PaymentEntity::toPayment);
    }
}
