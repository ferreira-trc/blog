package org.rumos.blog.model.dtos.entities.user;

import org.rumos.blog.model.enums.Role;

public record UserDTOToShow(Long id, String email ,String userName, Role role) {

}