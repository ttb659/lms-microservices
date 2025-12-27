package com.example.analyticsservice.service;

import com.example.analyticsservice.client.EnrollmentClient;
import com.example.analyticsservice.client.PaymentClient;
import com.example.analyticsservice.dto.EnrollmentDto;
import com.example.analyticsservice.dto.PaymentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnalyticsService {

    private final EnrollmentClient enrollmentClient;
    private final PaymentClient paymentClient;

    public long totalEnrollments() {
        return enrollmentClient.getAllEnrollments().length;
    }

    public Map<String, Long> enrollmentsByCourse() {
        return Arrays.stream(enrollmentClient.getAllEnrollments())
                .collect(Collectors.groupingBy(
                        EnrollmentDto::courseId,
                        Collectors.counting()
                ));
    }

    public Map<String, Double> revenueByCourse() {
        return Arrays.stream(paymentClient.getAllPayments())
                .filter(p -> "PAID".equals(p.status()))
                .collect(Collectors.groupingBy(
                        PaymentDto::courseId,
                        Collectors.summingDouble(PaymentDto::amount)
                ));
    }
}
