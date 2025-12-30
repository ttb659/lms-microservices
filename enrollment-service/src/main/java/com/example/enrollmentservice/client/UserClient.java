package com.example.enrollmentservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class UserClient {

    private final RestTemplate restTemplate;

    public void validateUser(Long userId) {
        restTemplate.getForObject(
                "http://user-service:8081/users/" + userId,
                Void.class
        );
    }
}
