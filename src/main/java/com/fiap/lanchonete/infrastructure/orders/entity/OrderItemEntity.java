package com.fiap.lanchonete.infrastructure.orders.entity;

import com.fiap.lanchonete.entities.orders.OrderItem;
import com.fiap.lanchonete.infrastructure.products.entity.ProductEntity; // Usando ProductEntity
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id") // Apenas para deixar claro o relacionamento com ProductEntity
    private ProductEntity product;

    private BigDecimal unitPrice;

    private int quantity;

    private String observation;

    private BigDecimal totalPrice;

    public OrderItemEntity() {}

    public OrderItemEntity(OrderItem orderItem, OrderEntity orderEntity) {
        this.id = orderItem.getId();
        this.product = new ProductEntity(orderItem.getProduct()); // Convertendo para ProductEntity
        //this.unitPrice = orderItem.getUnitPrice();
        this.quantity = orderItem.getQuantity();
        this.observation = orderItem.getObservation();
        this.totalPrice = orderItem.getTotalPrice();
        this.order = orderEntity;
    }

    public OrderItem toOrderItem() {
        return new OrderItem(
                id,
                product.toProduct(), // Convertendo de volta para Product
                quantity,
                observation
        );
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
