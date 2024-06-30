package org.rumos.blog.model.dtos.entities.person;

/**
 * A data transfer object (DTO) representing person details to update.
 * <p>
 * This DTO encapsulates fields that can be updated for a person,
 * including their name, email, and birth date.
 */
public record PersonDTOToUpdate(String name, String email, String birthDay) {

}
