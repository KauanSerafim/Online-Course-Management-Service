package com.learning.dev.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoursePutRequest {

    @NotNull(message = "The field 'id' cannot be null")
    @Schema(description = "Course's id", example = "1")
    private Long id;

    @NotBlank(message = "The field 'name' is required")
    @Schema(description = "Course's name", example = "Back End from level 1 to level 999+")
    private String name;

    @NotBlank(message = "The field 'description' is required")
    @Schema(description = "Course's description", example = "Learn how to be the Final Boss in Back End Development")
    private String description;
}
