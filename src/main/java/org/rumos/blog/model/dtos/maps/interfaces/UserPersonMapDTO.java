package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.UserPersonDTO;
import org.rumos.blog.model.entities.Person;
import org.rumos.blog.model.entities.User;

public interface UserPersonMapDTO {

    public UserPersonDTO convertToDTO(User user, Person person); 
}
