package org.rumos.blog.model.Exceptions;

/**
 * Custom exception to indicate resource not found scenarios.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
