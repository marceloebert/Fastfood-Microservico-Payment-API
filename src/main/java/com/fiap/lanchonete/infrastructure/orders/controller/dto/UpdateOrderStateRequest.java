package com.fiap.lanchonete.infrastructure.orders.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateOrderStateRequest {

    @NotBlank(message = "The newState field is required")
    private String newState;

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

}
