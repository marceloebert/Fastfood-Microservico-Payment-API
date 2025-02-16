package com.fiap.lanchonete.infrastructure.orders.controller.dto;

import com.fiap.lanchonete.entities.customers.Customer;
import com.fiap.lanchonete.infrastructure.orders.controller.dto.OrderItemRequest;
import java.util.List;

public class OrderRequest {

    private String document;
    private Customer customer;
    private List<OrderItemRequest> items;

    // Getters e Setters
    public String getDocument() {
        return document;
    }

    // Getters e Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
