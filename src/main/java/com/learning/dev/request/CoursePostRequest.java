package com.learning.dev.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoursePostRequest {

    @NotBlank(message = "The field 'name' is required")
    @Schema(description = "Course's name", example = "Backend from level 1 to level 999+")
    private String name;

    @NotBlank(message = "The field 'description' is required")
    @Schema(description = "Course's description", example = "Learn how to be the Final Boss in Backend Development")
    private String description;
}
