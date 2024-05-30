package org.rumos.blog.model.dtos.entities.user;

import org.rumos.blog.model.enums.Role;

public record UserDTOToAdd(String email ,String userName, String password, Role role) {

}
