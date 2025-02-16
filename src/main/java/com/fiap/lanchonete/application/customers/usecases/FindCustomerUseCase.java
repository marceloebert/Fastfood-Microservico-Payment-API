package com.fiap.lanchonete.application.customers.usecases;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.entities.customers.Customer;

import java.util.Optional;

public class FindCustomerUseCase {

    private final CustomerGateway customerGateway;

    public FindCustomerUseCase(CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    public Optional<Customer> findCustomer(String document) {
        return customerGateway.findCustomer(document);
    }
}
