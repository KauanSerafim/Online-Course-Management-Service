package com.learning.dev.mapper;

import com.learning.dev.domain.Student;
import com.learning.dev.response.StudentGetResponse;
import com.learning.dev.request.StudentPostRequest;
import com.learning.dev.response.StudentPostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapper {

    List<StudentGetResponse> toStudentGetResponse(List<Student> student);

    StudentPostResponse toStudentPostResponse(Student student);

    Student toStudent(StudentPostRequest student);
}
