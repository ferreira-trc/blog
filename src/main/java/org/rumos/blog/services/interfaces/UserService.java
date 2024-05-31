package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.entities.user.UserDTOToAdd;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;

public interface UserService {
    public List<UserDTOToShow> findAll();
    public UserDTOToShow findById(Long id);
    public UserDTOToShow add(UserDTOToAdd userDTO);
    public UserDTOToShow update(Long postId, UserDTOToUpdate userUpdated);
    public UserDTOToShow delete(Long id);
}
