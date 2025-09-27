package com.learning.dev.repository;

import com.learning.dev.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByNameIgnoreCase(String name);
}
