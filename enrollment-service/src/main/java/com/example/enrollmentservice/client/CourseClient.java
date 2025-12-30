package com.example.enrollmentservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CourseClient {

    private final RestTemplate restTemplate;

    public void validateCourse(String courseId) {
        restTemplate.getForObject(
         "http://course-service:8082/courses/" + courseId,
                void.class
        );
    }
}
