package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.entities.products.Product;

import java.util.Optional;
import java.util.UUID;

public class GetProductByIdUseCase {

    private final ProductGateway productGateway;

    public GetProductByIdUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public Optional<Product> getById(UUID id) {
        return productGateway.getById(id);
    }
}
