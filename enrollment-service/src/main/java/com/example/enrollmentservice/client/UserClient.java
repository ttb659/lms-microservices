package com.example.enrollmentservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public void validateUser(Long userId) {
        String url = "http://user-service:8081/users/" + userId;
        restTemplate.getForObject(url, Object.class);
    }
}
