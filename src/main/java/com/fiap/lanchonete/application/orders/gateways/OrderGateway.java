package com.fiap.lanchonete.application.orders.gateways;

import com.fiap.lanchonete.entities.orders.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderGateway {
    Order save(Order order);
    List<Order> findAll();
    Optional<Order> findById(UUID id);
}


