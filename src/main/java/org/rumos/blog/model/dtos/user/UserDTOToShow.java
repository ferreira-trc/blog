package org.rumos.blog.model.dtos.user;

import org.rumos.blog.model.enums.Role;

public record UserDTOToShow(Long id, String email ,String userName, Role role) {

}
