package com.fiap.lanchonete.application.orders.usecases;

import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.entities.orders.Order;
import com.fiap.lanchonete.entities.orders.enums.OrderState;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllOrdersUseCase {

    private final OrderGateway orderGateway;

    public GetAllOrdersUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public List<Order> getAll() {

        List<Order> allOrders = orderGateway.findAll();

        List<Order> filteredOrders = allOrders.stream()
                .filter(order -> order.getState() != OrderState.FINISHED)
                .collect(Collectors.toList());


        return filteredOrders.stream()
                .sorted(Comparator.comparing((Order order) -> getOrderPriority(order.getState()))
                        .thenComparing(Order::getCreationTime))
                .collect(Collectors.toList());
    }

    private int getOrderPriority(OrderState state) {
        switch (state) {
            case READY:
                return 1;
            case PREPARING:
                return 2;
            case RECEIVED:
                return 3;
            default:
                return Integer.MAX_VALUE;
        }
    }
}
