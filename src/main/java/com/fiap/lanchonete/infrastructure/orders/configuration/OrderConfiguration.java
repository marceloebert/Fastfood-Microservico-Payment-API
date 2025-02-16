package com.fiap.lanchonete.infrastructure.orders.configuration;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.application.orders.usecases.CreateOrderUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetAllOrdersUseCase;
import com.fiap.lanchonete.application.orders.usecases.GetOrderByIdUseCase;
import com.fiap.lanchonete.application.orders.usecases.UpdateOrderStateUseCase;
import com.fiap.lanchonete.application.orders.gateways.OrderGateway;
import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

    @Bean
    public CreateOrderUseCase createOrderUseCase(OrderGateway orderGateway, ProductGateway productGateway, CustomerGateway customerGateway, PaymentGateway paymentGateway) {
        return new CreateOrderUseCase(orderGateway, productGateway,customerGateway,paymentGateway);
    }

    @Bean
    public GetAllOrdersUseCase getAllOrdersUseCase(OrderGateway orderGateway) {
        return new GetAllOrdersUseCase(orderGateway);
    }

    @Bean
    public GetOrderByIdUseCase getOrderByIdUseCase(OrderGateway orderGateway) {
        return new GetOrderByIdUseCase(orderGateway);
    }

    @Bean
    public UpdateOrderStateUseCase updateOrderStateUseCase(OrderGateway orderGateway) {
        return new UpdateOrderStateUseCase(orderGateway);
    }
}
