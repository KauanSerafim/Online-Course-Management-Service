package com.learning.dev.controller;

import com.learning.dev.exception.CourseNameAlreadyExistsException;
import com.learning.dev.mapper.CourseMapper;
import com.learning.dev.request.CoursePostRequest;
import com.learning.dev.request.CoursePutRequest;
import com.learning.dev.response.CourseGetResponse;
import com.learning.dev.response.CoursePostResponse;
import com.learning.dev.response.CoursePutResponse;
import com.learning.dev.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/courses")
@RequiredArgsConstructor
@Tag(name = "Course API", description = "Course related endpoints")
public class CourseController {

    private final CourseService service;
    private final CourseMapper mapper;

    @GetMapping
    @Operation(summary = "Get Student")
    public ResponseEntity<List<CourseGetResponse>> getAllCourses(@RequestParam(required = false) String name) {

        var course = service.findAll(name);

        var response = mapper.toCourseGetResponse(course);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    @Operation(summary = "Save Course",
            responses = {
                    @ApiResponse(description = "Save Course in the database",
                            responseCode = "201",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CoursePostResponse.class))
                    ),
                    @ApiResponse(description = "Bad Request",
                            responseCode = "400",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CourseNameAlreadyExistsException.class)))
            })
    public ResponseEntity<CoursePostResponse> save(@RequestBody @Valid CoursePostRequest request) {

        var course = mapper.toCourse(request);

        var courseSaved = service.save(course);

        var response = mapper.toCoursePostResponse(courseSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Course",
            responses = {
                    @ApiResponse(description = "Delete Course in the database",
                            responseCode = "200"),
                    @ApiResponse(description = "Bad Request",
                            responseCode = "400",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    @Operation(summary = "Update Course",
            responses = {
                    @ApiResponse(description = "Update Course in the database",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CoursePutResponse.class))
                    ),
                    @ApiResponse(description = "Bad Request",
                            responseCode = "400",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    public ResponseEntity<CoursePutResponse> update(@RequestBody @Valid CoursePutRequest request) {

        var course = mapper.toCourse(request);

        var courseUpdated = service.update(course);

        var response = mapper.toCoursePutResponse(courseUpdated);

        return ResponseEntity.ok(response);
    }
}
