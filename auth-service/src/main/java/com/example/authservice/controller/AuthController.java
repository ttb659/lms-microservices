package com.example.authservice.controller;

import com.example.authservice.dto.LoginRequest;
import com.example.authservice.service.KeycloakAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final KeycloakAuthService authService;

    @PostMapping("/test")
    public String test() {
        return "OK";
    }


    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        return authService.login(
                request.username(),
                request.password()
        );
    }
}
