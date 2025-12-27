package com.example.paymentservice.service;

import com.example.paymentservice.dto.PaymentRequest;
import com.example.paymentservice.model.Payment;
import com.example.paymentservice.model.PaymentStatus;
import com.example.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final Random random = new Random();

    public Payment processPayment(PaymentRequest request) {

        PaymentStatus status =
                random.nextBoolean() ? PaymentStatus.PAID : PaymentStatus.FAILED;

        Payment payment = Payment.builder()
                .userId(request.userId())
                .courseId(request.courseId())
                .amount(request.amount())
                .status(status)
                .paymentDate(LocalDateTime.now())
                .build();

        return paymentRepository.save(payment);
    }
}