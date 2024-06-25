package org.rumos.blog.model.dtos.entities;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;

public record RegisterDTO(UserDTOToRegister userDTO, PersonDTOToRegister personDTO) {

}
