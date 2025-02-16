package com.fiap.lanchonete.application.products.usecases;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.entities.products.Product;

import java.util.List;

public class GetProductsByCategoryUseCase {

    private final ProductGateway productGateway;

    public GetProductsByCategoryUseCase(ProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    public List<Product> getByCategory(String category) {
        return productGateway.getByCategory(category);
    }
}
