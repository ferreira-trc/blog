package org.rumos.blog.model.dtos.user;

import org.rumos.blog.model.enums.Role;

public record UserDTOToUpdate(String email ,String userName, String password, Role role) {
    
}
