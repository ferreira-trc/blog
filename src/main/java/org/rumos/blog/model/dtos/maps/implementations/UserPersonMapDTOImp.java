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

@Component
public class UserPersonMapDTOImp implements UserPersonMapDTO {

    @Autowired
    public UserMapDTO userMapDTO;
    
    @Autowired
    public PersonMapDTO personMapDTO;

    public UserPersonDTO convertToDTO (User user, Person person){
        UserDTOToShow userDTO = userMapDTO.convertToDTO(user);
        PersonDTOToShow personDTO = personMapDTO.convertToDTO(person);

        return new UserPersonDTO(userDTO, personDTO);
    }
}
