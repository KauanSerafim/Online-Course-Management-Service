package com.learning.dev.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentPostRequest {

    @NotBlank(message = "The field 'name' is required")
    @Schema(description = "Student's name", example = "Lamzu Mathew")
    private String name;

    @NotBlank(message = "The field 'email' is required")
    @Schema(description = "Student's email. Must be unique", example = "lamzu.mathew@example.com")
    private String email;
}
