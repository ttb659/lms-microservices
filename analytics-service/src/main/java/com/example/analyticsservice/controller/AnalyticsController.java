package com.example.analyticsservice.controller;


import com.example.analyticsservice.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @GetMapping("/enrollments/count")
    public long totalEnrollments() {
        return analyticsService.totalEnrollments();
    }

    @GetMapping("/enrollments/by-course")
    public Map<String, Long> enrollmentsByCourse() {
        return analyticsService.enrollmentsByCourse();
    }

    @GetMapping("/revenue/by-course")
    public Map<String, Double> revenueByCourse() {
        return analyticsService.revenueByCourse();
    }
}
