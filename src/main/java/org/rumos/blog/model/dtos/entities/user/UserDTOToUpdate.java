package org.rumos.blog.model.dtos.entities.user;

/**
 * A data transfer object (DTO) representing user details to update.
 * <p>
 * This DTO encapsulates the username and password fields for updating user information.
 */
public record UserDTOToUpdate(String userName, String password) {
    
}
