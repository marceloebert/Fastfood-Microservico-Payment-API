package com.fiap.lanchonete.infrastructure.customers.repository;

import com.fiap.lanchonete.application.customers.gateways.CustomerGateway;
import com.fiap.lanchonete.entities.customers.Customer;
import com.fiap.lanchonete.infrastructure.customers.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryImpl implements CustomerGateway {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Autowired
    public CustomerRepositoryImpl(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity(customer);
        customerEntity = jpaCustomerRepository.save(customerEntity);
        return customerEntity.toCustomer();
    }

    @Override
    public Optional<Customer> findCustomer(String document) {
        return jpaCustomerRepository.findCustomerByDocument(document).map(CustomerEntity::toCustomer);
    }
}