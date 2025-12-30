package com.example.paymentservice.controller;

import com.example.paymentservice.dto.PaymentRequest;
import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repository.PaymentRepository;
import com.example.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public Payment pay(@Valid @RequestBody PaymentRequest request) {
        return paymentService.processPayment(request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

}