package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.UserMapDTO;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.model.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class UserMapDTOImp implements UserMapDTO{

    @Override
    public User convertToClass(UserDTOToRegister entityDTO) {
        User entity = new User();        
        entity.setUserName(entityDTO.userName());
        entity.setPassword(entityDTO.password());       

        return entity;
    }

    @Override
    public User convertToClass(UserDTOToUpdate entityDTO, User entity) {        
        entity.setUserName(entityDTO.userName());
        entity.setPassword(entityDTO.password());        

        return entity;
    }

    @Override
    public UserDTOToShow convertToDTO(User entity) {
        Long id = entity.getId();        
        String userName = entity.getUserName();
        Role role = entity.getRole();
        UserDTOToShow entityDTO = new UserDTOToShow(id, userName, role);

        return entityDTO;
    }
    
}
