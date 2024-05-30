package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.user.UserDTOToAdd;
import org.rumos.blog.model.dtos.user.UserDTOToShow;
import org.rumos.blog.model.dtos.user.UserDTOToUpdate;
import org.rumos.blog.model.entities.User;

public interface UserMapDTO extends EntityMapDTO<User, UserDTOToShow, UserDTOToAdd, UserDTOToUpdate>{

}
