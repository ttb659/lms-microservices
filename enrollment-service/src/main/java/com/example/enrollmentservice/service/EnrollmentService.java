package com.example.enrollmentservice.service;

import com.example.enrollmentservice.client.CourseClient;
import com.example.enrollmentservice.client.UserClient;
import com.example.enrollmentservice.dto.EnrollmentRequest;
import com.example.enrollmentservice.mode.Enrollment;
import com.example.enrollmentservice.mode.EnrollmentStatus;
import com.example.enrollmentservice.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserClient userClient;
    private final CourseClient courseClient;

    public Enrollment enroll(EnrollmentRequest request) {

        // Vérifier User & Course
        userClient.validateUser(request.userId());
        courseClient.validateCourse(request.courseId());

        enrollmentRepository.findByUserIdAndCourseId(
                request.userId(),
                request.courseId()
        ).ifPresent(e -> {
            throw new RuntimeException("User already enrolled in this course");
        });

        Enrollment enrollment = Enrollment.builder()
                .userId(request.userId())
                .courseId(request.courseId())
                .status(EnrollmentStatus.ENROLLED)
                .enrolledAt(LocalDateTime.now())
                .build();

        return enrollmentRepository.save(enrollment);
    }
}
