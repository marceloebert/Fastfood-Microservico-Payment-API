package com.fiap.lanchonete.infrastructure.customers.entity;

import java.util.UUID;

import com.fiap.lanchonete.entities.customers.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank

    private String name;

    @NotBlank
    private String document;

    @NotBlank
    private String mail;


    public CustomerEntity(Customer customer){
        this.id = customer.getId();
        this.name = customer.getName();
        this.document = customer.getDocument();
        this.mail = customer.getMail();
    }

    public Customer toCustomer(){return new Customer(this.id, this.name, this.document, this.mail);}

}
