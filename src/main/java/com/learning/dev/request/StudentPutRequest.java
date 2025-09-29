package com.learning.dev.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentPutRequest {

    private Long id;

    private String name;

    private String email;
}
