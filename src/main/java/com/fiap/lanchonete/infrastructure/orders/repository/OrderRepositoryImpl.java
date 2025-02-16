package com.fiap.lanchonete.infrastructure.orders.repository;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.entities.orders.Order;
import com.fiap.lanchonete.infrastructure.orders.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryImpl implements OrderGateway {

    private final JpaOrderRepository jpaOrderRepository;

    @Autowired
    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = new OrderEntity(order);
        return jpaOrderRepository.save(orderEntity).toOrder();
    }

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository.findAll().stream()
                .map(OrderEntity::toOrder)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return jpaOrderRepository.findById(id).map(OrderEntity::toOrder);
    }
}

