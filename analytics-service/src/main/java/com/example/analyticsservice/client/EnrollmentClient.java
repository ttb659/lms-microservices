package com.example.analyticsservice.client;

import com.example.analyticsservice.dto.EnrollmentDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EnrollmentClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public EnrollmentDto[] getAllEnrollments() {
        return restTemplate.getForObject(
                "http://enrollment-service:8083/enrollments",
                EnrollmentDto[].class
        );
    }
}