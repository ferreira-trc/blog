package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;

public interface UserService {
    public List<UserDTOToShow> findAll();
    public UserDTOToShow findById(Long id);
    public UserDTOToShow register(UserDTOToRegister userDTO);
    public UserDTOToShow update(Long postId, UserDTOToUpdate userUpdated);
    public UserDTOToShow delete(Long id);
}
