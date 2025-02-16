package com.fiap.lanchonete.entities.orders.enums;

public enum OrderState {
    PENDING,    // Pedido aguardando confirmação de pagamento para ir para cozinha
    RECEIVED,   // Pedido recebido pela cozinha após a confirmação de pagamento
    PREPARING,  // Pedido está sendo preparado
    READY,      // Pedido finalizado pelo cozinha
    FINISHED    // Pedido entregue para o cliente
}
