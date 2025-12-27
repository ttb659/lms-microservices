package com.example.analyticsservice.dto;

public record PaymentDto(
        Long id,
        Long userId,
        String courseId,
        double amount,
        String status
) {}