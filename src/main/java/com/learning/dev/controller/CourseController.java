package com.learning.dev.controller;

import com.learning.dev.domain.Course;
import com.learning.dev.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(@RequestParam(required = false) String name) {
        var response = service.findAll(name);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Course> save(@RequestBody Course course) {
        var response = service.save(course);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> delete(@PathVariable Long courseId) {
        service.delete(courseId);

        return ResponseEntity.noContent().build();
    }
}
