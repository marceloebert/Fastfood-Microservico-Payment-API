package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.entities.products.Product;

import java.util.List;

public class GetAllProductsUseCase {

    private final ProductGateway productGateway;

    public GetAllProductsUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<Product> getAll() {
        return productGateway.getAll();
    }
}
