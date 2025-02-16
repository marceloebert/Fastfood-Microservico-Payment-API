package com.fiap.lanchonete.application.customers.gateways;

import java.util.Optional;

import com.fiap.lanchonete.entities.customers.Customer;

public interface CustomerGateway {

    Customer save (Customer customer);
    Optional<Customer> findCustomer( String document);

}
