package com.springboot.blog.springbootrestapiblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private Long fieldvalue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldvalue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldvalue)); // Post not found with id : 1
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldvalue = fieldvalue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Long getFieldvalue() {
        return fieldvalue;
    }
}
