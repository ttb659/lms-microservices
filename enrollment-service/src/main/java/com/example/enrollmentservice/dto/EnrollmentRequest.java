package com.example.enrollmentservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EnrollmentRequest(

        @NotNull
        Long userId,

        @NotBlank
        String courseId
) {}