package com.fiap.lanchonete.infrastructure.customers.controller.dto;

import java.util.UUID;

public class CustomerResponse {

    private UUID id;
    private String name;
    private String document;
    private String mail;

    public CustomerResponse(UUID id, String name, String document, String mail) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.mail = mail;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
