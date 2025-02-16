package com.fiap.lanchonete.infrastructure.products.configuration;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.application.products.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public CreateProductUseCase createProductUseCase(ProductGateway productGateway) {
        return new CreateProductUseCase(productGateway);
    }

    @Bean
    public GetAllProductsUseCase getAllProductsUseCase(ProductGateway productGateway) {
        return new GetAllProductsUseCase(productGateway);
    }

    @Bean
    public GetProductByIdUseCase getProductByIdUseCase(ProductGateway productGateway) {
        return new GetProductByIdUseCase(productGateway);
    }

    @Bean
    public GetProductsByCategoryUseCase getProductsByCategoryUseCase(ProductGateway productGateway) {
        return new GetProductsByCategoryUseCase(productGateway);
    }

    @Bean
    public RemoveProductUseCase removeProductUseCase(ProductGateway productGateway) {
        return new RemoveProductUseCase(productGateway);
    }

    @Bean
    public UpdateProductUseCase updateProductUseCase(ProductGateway productGateway) {
        return new UpdateProductUseCase(productGateway);
    }
}
