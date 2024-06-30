package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;
import org.rumos.blog.model.entities.User;

/**
 * Interface defining methods to map between a User entity and its DTO representations for showing,
 * registering, and updating.
 */
public interface UserMapDTO extends EntityMapDTO<User, UserDTOToShow, UserDTOToRegister, UserDTOToUpdate> {

}

