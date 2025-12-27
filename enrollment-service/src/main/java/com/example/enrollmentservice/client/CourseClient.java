package com.example.enrollmentservice.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CourseClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public void validateCourse(String courseId) {
        String url = "http://localhost:8082/courses/" + courseId;
        restTemplate.getForObject(url, Object.class);
    }
}
