package com.fiap.lanchonete.application.payments.usecases;

import com.fiap.lanchonete.application.orders.usecases.UpdateOrderStateUseCase;
import com.fiap.lanchonete.entities.payments.Payment;
import com.fiap.lanchonete.application.payments.gateways.PaymentGateway;
import org.springframework.http.ResponseEntity;
import com.fiap.lanchonete.crosscutting.util.RestClient;
import com.fiap.lanchonete.crosscutting.util.AppConfig;
import java.util.Map;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApprovePaymentUseCase {

    private final PaymentGateway paymentGateway;
    private final UpdateOrderStateUseCase updateOrderStateUseCase;
    private final RestClient restClient;
    private final AppConfig appConfig;

    public ApprovePaymentUseCase(PaymentGateway paymentGateway,UpdateOrderStateUseCase updateOrderStateUseCase, RestClient restClient,  AppConfig appConfig) {
        this.paymentGateway = paymentGateway;
        this.updateOrderStateUseCase = updateOrderStateUseCase;
        this.restClient = restClient;
        this.appConfig = appConfig;
    }

    public Payment approvePayment(UUID paymentId, String transactionId, BigDecimal amount) {
        Optional<Payment> optionalPayment = paymentGateway.GetPaymentById(paymentId);

        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            if (payment.isPending()) {
                payment.setAmount(amount);
                payment.approve(transactionId);

                String url = appConfig.getProductionApiUrl().replace("{ORDER-ID}",payment.getOrderId().toString());
                Map<String, String> productionPayload = Map.of("state", "RECEIVED");
                ResponseEntity<String> productionResponse = restClient.put(url, productionPayload, String.class, Map.of());

                //updateOrderStateUseCase.updateOrderState(payment.getOrderId(), "RECEIVED");
                return paymentGateway.save(payment);
            } else {
                throw new IllegalStateException("Payment is not pending");
            }

        } else {
            throw new IllegalArgumentException("Payment not found");
        }
    }
}
