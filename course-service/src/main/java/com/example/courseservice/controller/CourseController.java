package com.example.courseservice.controller;

import com.example.courseservice.dto.CourseRequest;
import com.example.courseservice.model.Course;
import com.example.courseservice.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PreAuthorize("hasRole('INSTRUCTOR')")
    @PostMapping
    public Course createCourse(@Valid @RequestBody CourseRequest request) {

        Course course = Course.builder()
                .title(request.title())
                .description(request.description())
                .instructorId(request.instructorId())
                .price(request.price())
                .level(request.level())
                .tags(request.tags())
                .build();

        return courseService.createCourse(course);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STUDENT','INSTRUCTOR')")
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','STUDENT','INSTRUCTOR')")
    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @PreAuthorize("hasAnyRole('ADMIN','INSTRUCTOR')")
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}