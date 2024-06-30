package org.rumos.blog.model.dtos.entities;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;

/**
 * A data transfer object (DTO) representing combined information of a user and a person.
 * <p>
 * This DTO encapsulates a {@link UserDTOToShow} and a {@link PersonDTOToShow} to provide
 * unified information about a user and their associated person details.
 */
public record UserPersonDTO(UserDTOToShow user, PersonDTOToShow person) {

}
