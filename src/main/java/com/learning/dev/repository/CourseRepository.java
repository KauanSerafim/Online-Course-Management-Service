package com.learning.dev.repository;

import com.learning.dev.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseByNameIgnoreCase(String name);
}
