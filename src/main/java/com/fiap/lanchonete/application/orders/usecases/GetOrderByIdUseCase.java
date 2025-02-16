package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.entities.orders.Order;

import java.util.Optional;
import java.util.UUID;

public class GetOrderByIdUseCase {

    private final OrderGateway orderGateway;

    public GetOrderByIdUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Optional<Order> getOrderById(UUID id) {

        return orderGateway.findById(id);
    }
}
