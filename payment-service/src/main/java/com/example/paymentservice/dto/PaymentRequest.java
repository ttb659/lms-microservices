package com.example.paymentservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PaymentRequest(

        @NotNull
        Long userId,

        @NotBlank
        String courseId,

        @Positive
        double amount
) {}