package com.fiap.lanchonete.infrastructure.orders.controller.mapper;

import com.fiap.lanchonete.entities.orders.Order;
import com.fiap.lanchonete.entities.orders.OrderItem;
import com.fiap.lanchonete.infrastructure.orders.controller.dto.OrderItemRequest;
import com.fiap.lanchonete.infrastructure.orders.controller.dto.OrderRequest;
import com.fiap.lanchonete.infrastructure.orders.controller.dto.OrderResponse;
import com.fiap.lanchonete.infrastructure.orders.controller.dto.OrderItemResponse;
import com.fiap.lanchonete.infrastructure.payments.controller.mapper.PaymentDTOMapper;
import com.fiap.lanchonete.infrastructure.customers.controller.mapper.CustomerDTOMapper;
import com.fiap.lanchonete.infrastructure.products.controller.mapper.ProductDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDTOMapper {

    private final PaymentDTOMapper paymentDTOMapper;
    private final CustomerDTOMapper customerDTOMapper;
    private final ProductDTOMapper productDTOMapper;

    @Autowired
    public OrderDTOMapper(PaymentDTOMapper paymentDTOMapper, CustomerDTOMapper customerDTOMapper, ProductDTOMapper productDTOMapper) {
        this.paymentDTOMapper = paymentDTOMapper;
        this.customerDTOMapper = customerDTOMapper;
        this.productDTOMapper = productDTOMapper;
    }

    public Order toOrder(OrderRequest orderRequest) {
        List<OrderItem> items = orderRequest.getItems().stream()
                .map(this::toOrderItem)
                .collect(Collectors.toList());

        return new Order(orderRequest.getCustomer(), items);
    }

    public OrderItem toOrderItem(OrderItemRequest itemRequest) {
        return new OrderItem(
                itemRequest.getProductId(),
                itemRequest.getQuantity(),
                itemRequest.getObservation()
        );
    }

    public OrderResponse toOrderResponse(Order order) {
        List<OrderItemResponse> items = order.getItems().stream()
                .map(this::toOrderItemResponse)
                .collect(Collectors.toList());

        OrderResponse response = new OrderResponse();
        response.setId(order.getId());

        if (order.getCustomer() != null) {
            response.setCustomer(customerDTOMapper.toCustomerResponse(order.getCustomer()));
        }

        response.setItems(items);
        response.setTotalPrice(order.getTotalPrice());
        response.setState(order.getState());
        response.setCreationTime(order.getCreationTime());

        if (order.getPayment() != null) {
            response.setPayment(paymentDTOMapper.toPaymentResponse(order.getPayment()));
        }

        return response;
    }

    public OrderItemResponse toOrderItemResponse(OrderItem orderItem) {
        OrderItemResponse response = new OrderItemResponse();
        response.setId(orderItem.getId());
        response.setProduct(productDTOMapper.toProductResponse(orderItem.getProduct()));
        response.setQuantity(orderItem.getQuantity());
        response.setObservation(orderItem.getObservation());
        response.setTotalPrice(orderItem.getTotalPrice());
        return response;
    }
}
