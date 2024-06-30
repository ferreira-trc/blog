package org.rumos.blog.model.dtos.entities;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;

/**
 * A data transfer object (DTO) representing the data required for user registration.
 * <p>
 * This DTO encapsulates a {@link UserDTOToRegister} and a {@link PersonDTOToRegister}
 * to facilitate the registration process.
 */
public record RegisterDTO(UserDTOToRegister userDTO, PersonDTOToRegister personDTO) {

}
