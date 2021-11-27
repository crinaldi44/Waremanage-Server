package com.testing.warmanagespring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A DuplicateResourceException is thrown if the target resource currently
 * exists on the server. Common use cases include attempting to create a user with
 * a specified username which already exists.
 * @ResponseStatus HttpStatus.CONFLICT 409
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateResourceException extends RuntimeException {

    /**
     * Represents the attempted resource to access.
     */
    private String resourceName;

    /**
     * Default: Constructs a new DuplicateResourceException.
     */
    public DuplicateResourceException() {
        super("The requested resource has already been found");
    }

    /**
     * Constructor: Constructs a new DuplicateResourceException.
     * @param resourceName
     */
    public DuplicateResourceException(String resourceName) {
        super("The requested resource has already been found: " + resourceName);
        this.resourceName = resourceName;
    }

    /**
     * Gets the resource name that is attempted for access.
     * @return
     */
    public String getResourceName() {
        return resourceName;
    }

}
