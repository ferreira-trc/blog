package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.user.UserDTOToAdd;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;
import org.rumos.blog.model.entities.User;

public interface UserMapDTO extends EntityMapDTO<User, UserDTOToShow, UserDTOToAdd, UserDTOToUpdate>{

}
