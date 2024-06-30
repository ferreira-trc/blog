package org.rumos.blog.model.Exceptions;

/**
 * Custom exception to indicate access denied scenarios.
 */
public class AccessDeniedException extends RuntimeException {

    /**
     * Constructs a new AccessDeniedException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
    public AccessDeniedException(String message) {
        super(message);
    }
}

