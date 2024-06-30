package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository interface for performing CRUD operations on {@link Person} entities.
 * Extends {@link JpaRepository} to inherit basic CRUD methods for entities.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * Retrieves a {@link Person} entity by its email address.
     *
     * @param email The email address of the person to retrieve.
     * @return An {@link Optional} containing the {@link Person} entity with the specified email address,
     *         or empty if no such entity exists.
     */
    Optional<Person> findByEmail(String email);
}

