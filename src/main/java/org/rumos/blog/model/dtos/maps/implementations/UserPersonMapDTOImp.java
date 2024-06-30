package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.UserPersonDTO;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.maps.interfaces.PersonMapDTO;
import org.rumos.blog.model.dtos.maps.interfaces.UserMapDTO;
import org.rumos.blog.model.dtos.maps.interfaces.UserPersonMapDTO;
import org.rumos.blog.model.entities.Person;
import org.rumos.blog.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link UserPersonMapDTO} interface that provides a method
 * to convert a combination of {@link User} and {@link Person} entities into a single
 * {@link UserPersonDTO}.
 */
@Component
public class UserPersonMapDTOImp implements UserPersonMapDTO {

    @Autowired
    private UserMapDTO userMapDTO;
    
    @Autowired
    private PersonMapDTO personMapDTO;

    /**
     * Converts a combination of {@link User} and {@link Person} entities into a
     * {@link UserPersonDTO}.
     *
     * @param user   The {@link User} entity to be converted.
     * @param person The {@link Person} entity to be converted.
     * @return A {@link UserPersonDTO} containing data from {@code user} and {@code person}.
     */
    @Override
    public UserPersonDTO convertToDTO(User user, Person person) {
        UserDTOToShow userDTO = userMapDTO.convertToDTO(user);
        PersonDTOToShow personDTO = personMapDTO.convertToDTO(person);

        return new UserPersonDTO(userDTO, personDTO);
    }
}

