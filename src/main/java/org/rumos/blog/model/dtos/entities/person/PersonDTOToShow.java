package org.rumos.blog.model.dtos.entities.person;

/**
 * A data transfer object (DTO) representing person details to show.
 * <p>
 * This DTO encapsulates essential information about a person,
 * including their ID, name, email, and birth date.
 */
public record PersonDTOToShow(Long id, String name, String email, String birthDay) {

}
