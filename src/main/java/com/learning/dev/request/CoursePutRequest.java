package com.learning.dev.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoursePutRequest {

    private Long id;

    private String name;

    private String description;
}
