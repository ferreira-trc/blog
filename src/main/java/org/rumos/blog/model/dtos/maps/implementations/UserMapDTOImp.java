package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.UserMapDTO;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.model.enums.Role;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link UserMapDTO} interface that provides methods
 * to convert between {@link User} entities and various DTOs representing
 * user data.
 */
@Component
public class UserMapDTOImp implements UserMapDTO {

    /**
     * Converts a {@link UserDTOToRegister} DTO to a {@link User} entity.
     *
     * @param entityDTO The {@link UserDTOToRegister} DTO containing user registration data.
     * @return A {@link User} entity populated with data from {@code entityDTO}.
     */
    @Override
    public User convertToClass(UserDTOToRegister entityDTO) {
        User entity = new User();
        entity.setUserName(entityDTO.userName());
        entity.setPassword(entityDTO.password());

        return entity;
    }

    /**
     * Updates an existing {@link User} entity with data from {@link UserDTOToUpdate}.
     *
     * @param entityDTO The {@link UserDTOToUpdate} DTO containing updated user data.
     * @param entity    The existing {@link User} entity to be updated.
     * @return The updated {@link User} entity.
     */
    @Override
    public User convertToClass(UserDTOToUpdate entityDTO, User entity) {
        entity.setUserName(entityDTO.userName());
        entity.setPassword(entityDTO.password());

        return entity;
    }

    /**
     * Converts a {@link User} entity to a {@link UserDTOToShow} DTO.
     *
     * @param entity The {@link User} entity to be converted.
     * @return A {@link UserDTOToShow} DTO populated with data from {@code entity}.
     */
    @Override
    public UserDTOToShow convertToDTO(User entity) {
        Long id = entity.getId();
        String userName = entity.getUserName();
        Role role = entity.getRole();
        UserDTOToShow entityDTO = new UserDTOToShow(id, userName, role);

        return entityDTO;
    }
    
}

