package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.UserPersonDTO;
import org.rumos.blog.model.entities.Person;
import org.rumos.blog.model.entities.User;

/**
 * Interface defining a method to map a User and a Person entity to a UserPersonDTO.
 */
public interface UserPersonMapDTO {

    /**
     * Converts a User and a Person entity to a UserPersonDTO.
     * 
     * @param user   The User entity to convert.
     * @param person The Person entity to convert.
     * @return A UserPersonDTO representing the combined information from User and Person entities.
     */
    public UserPersonDTO convertToDTO(User user, Person person); 
}

