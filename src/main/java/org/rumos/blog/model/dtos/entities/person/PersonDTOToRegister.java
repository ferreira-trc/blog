package org.rumos.blog.model.dtos.entities.person;

/**
 * A data transfer object (DTO) representing person details for registration.
 * <p>
 * This DTO encapsulates essential information required for registering a person,
 * including their name, email, and birth date.
 */
public record PersonDTOToRegister(String name, String email, String birthDay) {

}
