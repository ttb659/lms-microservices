package com.example.analyticsservice.client;

import com.example.analyticsservice.dto.PaymentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public PaymentDto[] getAllPayments() {
        return restTemplate.getForObject(
                "http://payment-service:8084/payments",
                PaymentDto[].class
        );
    }
}