package com.example.courseservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

public record CourseRequest(

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotBlank
        String instructorId,

        @NotNull
        @PositiveOrZero
        double price,

        @NotBlank
        String level,

        List<String> tags
) {}
