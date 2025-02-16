package com.fiap.lanchonete.infrastructure.orders.entity;

import com.fiap.lanchonete.entities.orders.Order;
import com.fiap.lanchonete.entities.orders.OrderItem;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import com.fiap.lanchonete.entities.orders.enums.PaymentConfirmationStatus;
import com.fiap.lanchonete.infrastructure.customers.entity.CustomerEntity;
import com.fiap.lanchonete.infrastructure.payments.entity.PaymentEntity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentConfirmationStatus paymentConfirmationStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment; // Usando PaymentEntity agora

    private LocalDateTime creationTime;

    public OrderEntity() {}

    public OrderEntity(Order order) {
        this.id = order.getId();
        this.customer = new CustomerEntity(order.getCustomer());
        this.state = order.getState();
        this.totalPrice = order.getTotalPrice();
        this.payment = order.getPayment() != null ? new PaymentEntity(order.getPayment()) : null;
        this.creationTime = order.getCreationTime();
        this.items = order.getItems().stream()
                .map(item -> new OrderItemEntity(item, this))
                .toList();
    }

    public Order toOrder() {
        List<OrderItem> orderItems = this.items.stream()
                .map(OrderItemEntity::toOrderItem)
                .toList();


        return new Order(
                this.id,
                this.customer.toCustomer(),
                orderItems,
                this.state,
                this.totalPrice,
                this.paymentConfirmationStatus,
                this.payment != null ? this.payment.toPayment() : null,
                this.creationTime
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentConfirmationStatus getPaymentConfirmationStatus() {
        return paymentConfirmationStatus;
    }

    public void setPaymentConfirmationStatus(PaymentConfirmationStatus paymentConfirmationStatus) {
        this.paymentConfirmationStatus = paymentConfirmationStatus;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
