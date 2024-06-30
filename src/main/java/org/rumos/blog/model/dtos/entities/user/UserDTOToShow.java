package org.rumos.blog.model.dtos.entities.user;

import org.rumos.blog.model.enums.Role;

/**
 * A data transfer object (DTO) representing a user to show details.
 * <p>
 * This DTO encapsulates essential user details such as user ID, username, and role.
 */
public record UserDTOToShow(Long id, String userName, Role role) {

}
