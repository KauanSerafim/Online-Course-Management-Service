package com.learning.dev.service;

import com.learning.dev.domain.Student;
import com.learning.dev.exception.NotFoundException;
import com.learning.dev.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public List<Student> findAll(String name) {
        return name == null ? repository.findAll() : repository.findStudentByNameIgnoreCase(name);
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public void delete(Long id) {
        var student = findByIdOrThrowNotFound(id);
        repository.delete(student);
    }

    public Student update(Student student) {
        var studentSaved = findByIdOrThrowNotFound(student.getId());

        student.setId(studentSaved.getId());
        student.setRegistration_date(studentSaved.getRegistration_date());

        return repository.save(student);
    }

    private Student findByIdOrThrowNotFound(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student Not Found"));
    }
}
