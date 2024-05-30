package org.rumos.blog.model.dtos.maps;

import org.rumos.blog.model.dtos.user.UserDTOToAdd;
import org.rumos.blog.model.dtos.user.UserDTOToShow;
import org.rumos.blog.model.dtos.user.UserDTOToUpdate;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.model.enums.Role;

public class UserMapDTO implements EntityMapDTO<User, UserDTOToShow, UserDTOToAdd, UserDTOToUpdate>{

    @Override
    public User convertToClass(UserDTOToAdd entityDTO) {
        User entity = new User();
        entity.setEmail(entityDTO.email());
        entity.setUserName(entityDTO.userName());
        entity.setPassword(entityDTO.password());
        entity.setRole(entityDTO.role());

        return entity;
    }

    @Override
    public User convertToClass(UserDTOToUpdate entityDTO, User entity) {
        entity.setEmail(entityDTO.email());
        entity.setUserName(entityDTO.userName());
        entity.setPassword(entityDTO.password());
        entity.setRole(entityDTO.role());

        return entity;
    }

    @Override
    public UserDTOToShow convertToDTO(User entity) {
        Long id = entity.getId();
        String email = entity.getEmail();
        String userName = entity.getUserName();
        Role role = entity.getRole();
        UserDTOToShow entityDTO = new UserDTOToShow(id, email, userName, role);

        return entityDTO;
    }
    
}
