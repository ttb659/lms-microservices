package com.example.paymentservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String courseId;
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private LocalDateTime paymentDate;
}