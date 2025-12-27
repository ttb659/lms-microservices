package com.example.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(

        @NotBlank
        String keycloakId,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @NotNull
        String role
) {}
