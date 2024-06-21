package org.rumos.blog.model.dtos.entities.user;

import org.rumos.blog.model.enums.Role;

public record UserDTOToUpdate(String userName, String password, Role role) {
    
}
