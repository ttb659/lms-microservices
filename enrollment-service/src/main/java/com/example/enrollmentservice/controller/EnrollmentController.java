package com.example.enrollmentservice.controller;

import com.example.enrollmentservice.dto.EnrollmentRequest;
import com.example.enrollmentservice.mode.Enrollment;
import com.example.enrollmentservice.repository.EnrollmentRepository;
import com.example.enrollmentservice.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final EnrollmentRepository enrollmentRepository;

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping
    public Enrollment enroll(@Valid @RequestBody EnrollmentRequest request) {
        return enrollmentService.enroll(request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }
}
