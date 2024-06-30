package org.rumos.blog.model.dtos.entities;

/**
 * A data transfer object (DTO) representing authentication credentials.
 * <p>
 * This DTO encapsulates the login and password fields for authentication purposes.
 */
public record AuthenticatioDTO(String login, String password) {
} 
