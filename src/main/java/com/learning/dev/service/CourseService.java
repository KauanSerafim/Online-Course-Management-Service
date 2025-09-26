package com.learning.dev.service;

import com.learning.dev.domain.Course;
import com.learning.dev.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;

    public List<Course> findAll(String name) {
        return name == null ? repository.findAll() : repository.findCourseByNameIgnoreCase(name);
    }

    public Course save(Course course) {
        return repository.save(course);
    }

    public void delete(Long id) {
        var course = findByIdOrThrowRuntimeException(id);
        repository.delete(course);
    }

    private Course findByIdOrThrowRuntimeException(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }
}
