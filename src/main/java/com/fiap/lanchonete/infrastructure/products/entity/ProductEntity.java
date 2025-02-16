package com.fiap.lanchonete.infrastructure.products.entity;

import com.fiap.lanchonete.entities.products.Product;
import com.fiap.lanchonete.entities.products.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String description;

    @NotNull
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    // Construtor que mapeia de Product para ProductEntity
    public ProductEntity(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = product.getCategory();
    }

    // Método que converte de ProductEntity para Product
    public Product toProduct() {
        return new Product(this.id, this.description, this.price, this.category);
    }
}
