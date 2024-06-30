package org.rumos.blog.services.interfaces;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;

import java.util.List;

/**
 * Service interface for managing persons.
 */
public interface PersonService {

    /**
     * Retrieves all persons.
     *
     * @return A list of {@link PersonDTOToShow} representing all persons.
     */
    List<PersonDTOToShow> findAll();

    /**
     * Retrieves a person by their ID.
     *
     * @param id The ID of the person to retrieve.
     * @return The {@link PersonDTOToShow} representing the person if found, otherwise null.
     */
    PersonDTOToShow findById(Long id);

    /**
     * Updates an existing person.
     *
     * @param id            The ID of the person to update.
     * @param personUpdated The {@link PersonDTOToUpdate} object containing updated data for the person.
     * @return The {@link PersonDTOToShow} representing the updated person.
     */
    PersonDTOToShow update(Long id, PersonDTOToUpdate personUpdated);
}

