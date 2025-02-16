package com.fiap.lanchonete.application.customers.usecases;

import com.fiap.lanchonete.entities.customers.Customer;
import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;

import java.util.UUID;

public class RegisterCustomerUseCase {

    private final CustomerGateway customerGateway;

    public RegisterCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Customer save(Customer customer) {

        return customerGateway.save(customer);
    }
}