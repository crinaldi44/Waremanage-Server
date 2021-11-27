package com.testing.warmanagespring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A ResourceNotFoundException is thrown when an end-user attempts to
 * access a resource that does not exist within the database.
 * @ResponseStatus HttpStatus.NOT_FOUND 404
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Default: Constructs a new ResourceNotFoundException.
     */
    public ResourceNotFoundException() {
        super("Resource not found.");
    }

}
