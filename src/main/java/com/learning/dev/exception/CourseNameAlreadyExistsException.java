package com.learning.dev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CourseNameAlreadyExistsException extends ResponseStatusException {

    public CourseNameAlreadyExistsException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
