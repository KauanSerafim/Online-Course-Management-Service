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
public class StudentPutRequest {

    @NotNull(message = "The field 'id' cannot be null")
    @Schema(description = "Student's id", example = "1")
    private Long id;

    @NotBlank(message = "The field 'name' is required")
    @Schema(description = "Student's name", example = "Lamzu Matthew")
    private String name;

    @NotBlank(message = "The field 'email' is required")
    @Schema(description = "Student's email. Must be unique", example = "lamzu.matthew@example.com")
    private String email;
}
