package com.example.courseservice.service;

import com.example.courseservice.model.Course;
import com.example.courseservice.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course createCourse(Course course) {
        course.setCreatedAt(LocalDateTime.now());
        return courseRepository.save(course);
    }

    public Course getCourseById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
