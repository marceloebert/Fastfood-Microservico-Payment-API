package com.fiap.lanchonete.infrastructure.payments.controller;

import com.fiap.lanchonete.application.payments.usecases.ApprovePaymentUseCase;
import com.fiap.lanchonete.application.payments.usecases.CreatePaymentUseCase;
import com.fiap.lanchonete.application.payments.usecases.GetPaymentByIdUseCase;
import com.fiap.lanchonete.entities.payments.Payment;
import com.fiap.lanchonete.infrastructure.orders.controller.dto.OrderResponse;
import com.fiap.lanchonete.infrastructure.payments.controller.dto.CreatePaymentRequest;
import com.fiap.lanchonete.application.payments.usecases.GetPaymentByOrderIdUseCase;
import com.fiap.lanchonete.infrastructure.payments.controller.dto.PaymentApprovalRequest;
import com.fiap.lanchonete.infrastructure.payments.controller.dto.PaymentResponse;
import com.fiap.lanchonete.infrastructure.payments.controller.mapper.PaymentDTOMapper;
import com.fiap.lanchonete.application.payments.usecases.ApprovePaymentUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentApi {

    private final CreatePaymentUseCase createPaymentUseCase;
    private final GetPaymentByIdUseCase getPaymentByIdUseCase;
    private final PaymentDTOMapper paymentDTOMapper;
    private final GetPaymentByOrderIdUseCase getPaymentByOrderIdUseCase;
    private final ApprovePaymentUseCase approvePaymentUseCase;

    public PaymentApi(CreatePaymentUseCase createPaymentUseCase, PaymentDTOMapper paymentDTOMapper, GetPaymentByIdUseCase getPaymentByIdUseCase,GetPaymentByOrderIdUseCase getPaymentByOrderIdUseCase, ApprovePaymentUseCase approvePaymentUseCase) {
        this.createPaymentUseCase = createPaymentUseCase;
        this.paymentDTOMapper = paymentDTOMapper;
        this.getPaymentByIdUseCase = getPaymentByIdUseCase;
        this.getPaymentByOrderIdUseCase = getPaymentByOrderIdUseCase;
        this.approvePaymentUseCase = approvePaymentUseCase;
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody CreatePaymentRequest createPaymentRequestDTO) {
        Payment payment = createPaymentUseCase.createPayment(
                PaymentDTOMapper.toDomain(createPaymentRequestDTO));
        PaymentResponse paymentResponse = paymentDTOMapper.toPaymentResponse(payment);
        return ResponseEntity.ok(paymentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable UUID id) {
        return  getPaymentByIdUseCase.GetPaymentById(id)
                .map(payment -> ResponseEntity.ok(paymentDTOMapper.toPaymentResponse(payment)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<PaymentResponse> getPaymentByOrderId(@PathVariable UUID orderId) {
        return  getPaymentByOrderIdUseCase.getPaymentByOrderId(orderId)
                .map(payment -> ResponseEntity.ok(paymentDTOMapper.toPaymentResponse(payment)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/approve")
    public ResponseEntity<PaymentResponse> approvePayment(@RequestBody PaymentApprovalRequest paymentApprovalRequestDTO) {
        Payment payment = approvePaymentUseCase.approvePayment(
                paymentApprovalRequestDTO.getPaymentId(),
                paymentApprovalRequestDTO.getTransactionId(),
                paymentApprovalRequestDTO.getAmount());

        PaymentResponse paymentResponse = paymentDTOMapper.toPaymentResponse(payment);
        return ResponseEntity.ok(paymentResponse);
    }
}
