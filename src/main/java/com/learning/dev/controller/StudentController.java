package com.learning.dev.controller;

import com.learning.dev.mapper.StudentMapper;
import com.learning.dev.request.StudentPostRequest;
import com.learning.dev.request.StudentPutRequest;
import com.learning.dev.response.StudentGetResponse;
import com.learning.dev.response.StudentPostResponse;
import com.learning.dev.response.StudentPutResponse;
import com.learning.dev.service.StudentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
@Tag(name = "Student API", description = "Student related endpoints")
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
    public ResponseEntity<StudentPostResponse> save(@RequestBody @Valid StudentPostRequest request) {

        var student = mapper.toStudent(request);

        var studentSaved = service.save(student);

        var studentResponse = mapper.toStudentPostResponse(studentSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<StudentPutResponse> update(@RequestBody @Valid StudentPutRequest request) {

        var student = mapper.toStudent(request);

        var studentUpdated = service.update(student);

        var response = mapper.toStudentPutResponse(studentUpdated);

        return ResponseEntity.ok(response);
    }
}
