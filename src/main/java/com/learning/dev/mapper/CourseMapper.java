package com.learning.dev.mapper;

import com.learning.dev.domain.Course;
import com.learning.dev.request.CoursePostRequest;
import com.learning.dev.request.CoursePutRequest;
import com.learning.dev.response.CourseGetResponse;
import com.learning.dev.response.CoursePostResponse;
import com.learning.dev.response.CoursePutResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {

    List<CourseGetResponse> toCourseGetResponse(List<Course> course);

    CoursePostResponse toCoursePostResponse(Course course);

    CoursePutResponse toCoursePutResponse(Course course);

    Course toCourse(CoursePostRequest course);

    Course toCourse(CoursePutRequest course);

}
