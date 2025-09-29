package com.learning.dev.controller;

import com.learning.dev.mapper.CourseMapper;
import com.learning.dev.request.CoursePostRequest;
import com.learning.dev.request.CoursePutRequest;
import com.learning.dev.response.CourseGetResponse;
import com.learning.dev.response.CoursePostResponse;
import com.learning.dev.response.CoursePutResponse;
import com.learning.dev.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;
    private final CourseMapper mapper;

    @GetMapping
    public ResponseEntity<List<CourseGetResponse>> getAllCourses(@RequestParam(required = false) String name) {

        var course = service.findAll(name);

        var response = mapper.toCourseGetResponse(course);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CoursePostResponse> save(@RequestBody CoursePostRequest request) {

        var course = mapper.toCourse(request);

        var courseSaved = service.save(course);

        var response = mapper.toCoursePostResponse(courseSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> delete(@PathVariable Long courseId) {

        service.delete(courseId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<CoursePutResponse> update(@RequestBody CoursePutRequest request) {

        var course = mapper.toCourse(request);

        var courseUpdated = service.update(course);

        var response = mapper.toCoursePutResponse(courseUpdated);

        return ResponseEntity.ok(response);
    }
}
