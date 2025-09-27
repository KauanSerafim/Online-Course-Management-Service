package com.learning.dev.controller;

import com.learning.dev.domain.Student;
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

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String name) {
        var response = service.findAll(name);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        var response = service.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
