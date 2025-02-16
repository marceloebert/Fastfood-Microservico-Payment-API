package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.entities.orders.Order;
import com.fiap.lanchonete.entities.payments.Payment;

import java.util.UUID;

public class GetOrderPaymentProcessorUseCase {

    private final OrderGateway orderGateway;

    public GetOrderPaymentProcessorUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Order getOrderPaymentProcessor(UUID orderId, Payment payment) {
        Order order = orderGateway.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("\n" + "Order not found"));

        order.processPayment(payment);

        return orderGateway.save(order);
    }
}

