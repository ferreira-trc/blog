package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;

public interface UserService {
    public List<UserDTOToShow> findAll();
    public UserDTOToShow findById(Long id);
    public UserDTOToShow findByUserName(String userName);
    public UserDTOToShow register(UserDTOToRegister userDTO);
    public UserDTOToShow update(UserDTOToUpdate userUpdated);
    public UserDTOToShow updateUserRole(Long userId, String role);
    public UserDTOToShow delete(Long id);
}
