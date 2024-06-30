package org.rumos.blog.services.interfaces;

import org.rumos.blog.model.dtos.entities.UserPersonDTO;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;

/**
 * Service interface for user and person registration.
 */
public interface RegisterService {

    /**
     * Registers a new user and associated person.
     *
     * @param userDTO   The {@link UserDTOToRegister} object containing user registration data.
     * @param personDTO The {@link PersonDTOToRegister} object containing person registration data.
     * @return The {@link UserPersonDTO} representing the registered user and person.
     */
    UserPersonDTO register(UserDTOToRegister userDTO, PersonDTOToRegister personDTO);
}

