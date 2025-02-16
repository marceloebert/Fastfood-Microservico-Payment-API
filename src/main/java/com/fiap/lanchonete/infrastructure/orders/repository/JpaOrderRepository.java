package com.fiap.lanchonete.infrastructure.orders.repository;

import com.fiap.lanchonete.infrastructure.orders.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, UUID> {
}
