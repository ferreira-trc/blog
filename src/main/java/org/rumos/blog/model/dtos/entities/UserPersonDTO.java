package org.rumos.blog.model.dtos.entities;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;

public record UserPersonDTO(UserDTOToShow user, PersonDTOToShow person) {

}
