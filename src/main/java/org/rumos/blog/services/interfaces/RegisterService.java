package org.rumos.blog.services.interfaces;

import org.rumos.blog.model.dtos.entities.UserPersonDTO;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;

public interface RegisterService {

    public UserPersonDTO register(UserDTOToRegister userDTO, PersonDTOToRegister personDTO);
}
