package com.fiap.lanchonete.entities.orders;

import com.fiap.lanchonete.entities.customers.Customer;
import com.fiap.lanchonete.entities.orders.enums.OrderState;
import com.fiap.lanchonete.entities.orders.enums.PaymentConfirmationStatus;
import com.fiap.lanchonete.entities.payments.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private Customer customer;
    private List<OrderItem> items;
    private OrderState state;
    private BigDecimal totalPrice;
    private Payment payment;
    private LocalDateTime creationTime;


    public Order(Customer customer, List<OrderItem> items) {
        this(UUID.randomUUID(), customer, items);
    }


    public Order(UUID id, Customer customer, List<OrderItem> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.state = OrderState.PENDING;
        this.totalPrice = calculateTotalPrice();
        this.creationTime = LocalDateTime.now();
    }


    public Order(UUID id, Customer customer, List<OrderItem> items, OrderState state,
                 BigDecimal totalPrice, PaymentConfirmationStatus paymentConfirmationStatus,
                 Payment payment, LocalDateTime creationTime) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.state = state;
        this.totalPrice = totalPrice != null ? totalPrice : calculateTotalPrice();
        this.payment = payment;
        this.creationTime = creationTime;
    }


    private BigDecimal calculateTotalPrice() {
        return items.stream()
                .filter(item -> item != null && item.getProduct() != null && item.getTotalPrice() != null)
                .map(OrderItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void approvePayment(Payment payment) {
        this.payment = payment;
        this.state = OrderState.RECEIVED;
    }

    public void refusePayment() {
        this.payment = null;
        this.state = OrderState.PENDING;
    }

    public void processPayment(Payment payment) {
        if (payment != null) {
            if (payment.isPending()) {
                refusePayment();
            } else {
                approvePayment(payment);
            }
        }
    }

    public void updateState(OrderState newState) {
            this.state = newState;
    }
}