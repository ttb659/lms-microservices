package com.example.analyticsservice.controller;


import com.example.analyticsservice.service.AnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/enrollments/count")
    public long totalEnrollments() {
        return analyticsService.totalEnrollments();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/enrollments/by-course")
    public Map<String, Long> enrollmentsByCourse() {
        return analyticsService.enrollmentsByCourse();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/revenue/by-course")
    public Map<String, Double> revenueByCourse() {
        return analyticsService.revenueByCourse();
    }
}
