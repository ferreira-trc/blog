package org.rumos.blog.model.dtos.entities.user;

/**
 * A data transfer object (DTO) representing a post to update.
 * <p>
 * This DTO encapsulates fields necessary to update details of a post,
 * including its ID, title, and text content.
 */
public record UserDTOToRegister(String userName, String password) {

}
