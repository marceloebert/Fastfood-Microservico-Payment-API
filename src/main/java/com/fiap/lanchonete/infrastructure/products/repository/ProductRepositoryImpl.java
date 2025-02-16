package com.fiap.lanchonete.infrastructure.products.repository;

import com.fiap.lanchonete.application.products.gateways.ProductGateway;
import com.fiap.lanchonete.entities.products.Product;
import com.fiap.lanchonete.infrastructure.products.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProductRepositoryImpl implements ProductGateway {

    private final JpaProductRepository jpaProductRepository;

    @Autowired
    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product create(Product product) {
        ProductEntity productEntity = new ProductEntity(product);
        return jpaProductRepository.save(productEntity).toProduct();
    }

    @Override
    public List<Product> getAll() {
        return jpaProductRepository.findAll().stream()
                .map(ProductEntity::toProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getById(UUID id) {
        return jpaProductRepository.findById(id).map(ProductEntity::toProduct);
    }

    @Override
    public List<Product> getByCategory(String category) {
        return jpaProductRepository.findByCategory(category).stream()
                .map(ProductEntity::toProduct)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(UUID id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        ProductEntity productEntity = new ProductEntity(product);
        return jpaProductRepository.save(productEntity).toProduct();
    }
}
