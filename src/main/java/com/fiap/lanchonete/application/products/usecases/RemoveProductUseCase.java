package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;

import java.util.UUID;

public class RemoveProductUseCase {

    private final ProductGateway productGateway;

    public RemoveProductUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public void remove(UUID id) {
        productGateway.remove(id);
    }
}
