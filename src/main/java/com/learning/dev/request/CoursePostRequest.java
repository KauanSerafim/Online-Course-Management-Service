package com.learning.dev.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoursePostRequest {

    private String name;

    private String description;
}
