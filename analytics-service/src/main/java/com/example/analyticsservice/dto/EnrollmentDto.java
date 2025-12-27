package com.example.analyticsservice.dto;

public record EnrollmentDto(
        Long id,
        Long userId,
        String courseId,
        String status
) {}