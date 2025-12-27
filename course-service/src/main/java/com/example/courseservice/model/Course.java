package com.example.courseservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    private String id;

    private String title;
    private String description;
    private String instructorId;
    private double price;
    private String level;
    private List<String> tags;
    private LocalDateTime createdAt;
}