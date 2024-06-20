package org.rumos.blog.model.dtos.entities;

import org.rumos.blog.model.enums.Role;

public record RegisterDTO(String login, String password, Role role) {

}
