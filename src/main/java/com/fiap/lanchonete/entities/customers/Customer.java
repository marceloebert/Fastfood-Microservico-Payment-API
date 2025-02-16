package com.fiap.lanchonete.entities.customers;

import java.util.UUID;

public class Customer {

    private UUID id;
    private String name;
    private String document;
    private String mail;

    public Customer(UUID id, String name, String document, String mail) {
        this.id = id;
        this.mail = mail;
        this.document = document;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getMail() {
        return mail;
    }
}