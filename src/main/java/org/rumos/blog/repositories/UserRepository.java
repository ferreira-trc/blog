package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for performing CRUD operations on {@link User} entities.
 * Extends {@link JpaRepository} to inherit basic CRUD methods for entities.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Retrieves a user by their username.
     *
     * @param userName The username of the user to retrieve.
     * @return An {@link Optional} containing the {@link User} entity if found, otherwise empty.
     */
    Optional<User> findByUserName(String userName);
}


