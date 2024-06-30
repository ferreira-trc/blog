package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;

/**
 * Service interface for managing user operations.
 */
public interface UserService {

    /**
     * Retrieves all users.
     *
     * @return A list of {@link UserDTOToShow} representing all users.
     */
    List<UserDTOToShow> findAll();

    /**
     * Retrieves a user by their ID.
     *
     * @param id The ID of the user to retrieve.
     * @return The {@link UserDTOToShow} representing the user with the given ID.
     */
    UserDTOToShow findById(Long id);

    /**
     * Retrieves a user by their username.
     *
     * @param userName The username of the user to retrieve.
     * @return The {@link UserDTOToShow} representing the user with the given username.
     */
    UserDTOToShow findByUserName(String userName);

    /**
     * Updates an existing user.
     *
     * @param userUpdated The {@link UserDTOToUpdate} object containing updated user data.
     * @return The {@link UserDTOToShow} representing the updated user.
     */
    UserDTOToShow update(UserDTOToUpdate userUpdated);

    /**
     * Updates the role of a user.
     *
     * @param userId The ID of the user whose role is to be updated.
     * @param role   The new role for the user.
     * @return The {@link UserDTOToShow} representing the updated user with the new role.
     */
    UserDTOToShow updateUserRole(Long userId, String role);

    /**
     * Deletes a user.
     *
     * @param id The ID of the user to delete.
     * @return The {@link UserDTOToShow} representing the deleted user.
     */
    UserDTOToShow delete(Long id);
}

