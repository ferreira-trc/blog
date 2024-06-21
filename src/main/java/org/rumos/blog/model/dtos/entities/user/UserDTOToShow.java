package org.rumos.blog.model.dtos.entities.user;

import org.rumos.blog.model.enums.Role;

public record UserDTOToShow(Long id, String userName, Role role) {

}
