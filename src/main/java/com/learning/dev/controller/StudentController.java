package com.learning.dev.controller;

import com.learning.dev.domain.Student;
import com.learning.dev.mapper.StudentMapper;
import com.learning.dev.response.StudentGetResponse;
import com.learning.dev.request.StudentPostRequest;
import com.learning.dev.response.StudentPostResponse;
import com.learning.dev.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;
    private final StudentMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentGetResponse>> getStudents(@RequestParam(required = false) String name) {

        var studentList = service.findAll(name);

        var studentResponse = mapper.toStudentGetResponse(studentList);

        return ResponseEntity.ok(studentResponse);
    }

    @PostMapping
    public ResponseEntity<StudentPostResponse> save(@RequestBody StudentPostRequest request) {

        var student = mapper.toStudent(request);

        var studentSaved = service.save(student);

        var studentResponse = mapper.toStudentPostResponse(studentSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable Long studentId) {

        service.delete(studentId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Student> update(@RequestBody Student student) {

        var response = service.update(student);

        return ResponseEntity.ok(response);
    }
}
