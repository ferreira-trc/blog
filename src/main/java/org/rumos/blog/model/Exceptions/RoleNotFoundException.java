package org.rumos.blog.model.Exceptions;

/**
 * Custom exception to indicate role not found scenarios.
 */
public class RoleNotFoundException extends RuntimeException {

    /**
     * Constructs a new RoleNotFoundException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
    public RoleNotFoundException(String message) {
        super(message);
    }
}
