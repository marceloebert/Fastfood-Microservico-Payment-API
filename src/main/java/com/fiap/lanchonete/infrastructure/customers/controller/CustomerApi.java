package com.fiap.lanchonete.infrastructure.customers.controller;

import com.fiap.lanchonete.application.customers.usecases.RegisterCustomerUseCase;
import com.fiap.lanchonete.application.customers.usecases.FindCustomerUseCase;
import com.fiap.lanchonete.entities.customers.Customer;
import com.fiap.lanchonete.infrastructure.customers.controller.dto.CustomerRequest;
import com.fiap.lanchonete.infrastructure.customers.controller.dto.CustomerResponse;
import com.fiap.lanchonete.infrastructure.customers.controller.mapper.CustomerDTOMapper;
import com.fiap.lanchonete.crosscutting.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerApi {

    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final FindCustomerUseCase findCustomerUseCase;
    private final CustomerDTOMapper customerDTOMapper;

    @Autowired
    public CustomerApi(RegisterCustomerUseCase registerCustomerUseCase,
                       FindCustomerUseCase findCustomerUseCase,
                       CustomerDTOMapper customerDTOMapper) {
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
        this.customerDTOMapper = customerDTOMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> saveCustomer(@RequestBody @jakarta.validation.Valid CustomerRequest customerRequest) {
        Customer customerObjDomain = customerDTOMapper.toCustomer(customerRequest);
        Customer savedCustomer = registerCustomerUseCase.save(customerObjDomain);
        CustomerResponse response = customerDTOMapper.toCustomerResponse(savedCustomer);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{document}")
    public ResponseEntity<CustomerResponse> findCustomer(@PathVariable String document) {
        Optional<Customer> customer = findCustomerUseCase.findCustomer(document);
        Customer foundCustomer = customer.orElseThrow(NotFoundException::new);
        CustomerResponse response = customerDTOMapper.toCustomerResponse(foundCustomer);
        return ResponseEntity.ok(response);
    }
}
