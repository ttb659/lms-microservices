package com.example.enrollmentservice.mode;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "enrollments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"userId", "courseId"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String courseId;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    private LocalDateTime enrolledAt;
}
