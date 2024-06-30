package org.rumos.blog.controllers;

import java.util.List;

import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdateRole;
import org.rumos.blog.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * UserController is a REST controller that provides endpoints for managing users.
 * It supports retrieving all users, retrieving a specific user, updating user details,
 * updating user roles, and deleting users.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves all users.
     * 
     * @return a ResponseEntity containing a list of UserDTOToShow objects.
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTOToShow>> getAll() {
        List<UserDTOToShow> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Retrieves a user by ID.
     * 
     * @param id the ID of the user to retrieve.
     * @return a ResponseEntity containing the UserDTOToShow object of the user.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTOToShow> getById(@PathVariable Long id) {
        UserDTOToShow user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    /**
     * Updates user details.
     * 
     * @param userUpdated the UserDTOToUpdate object containing the updated user details.
     * @return a ResponseEntity containing the updated UserDTOToShow object.
     */
    @PutMapping
    public ResponseEntity<UserDTOToShow> put(@RequestBody UserDTOToUpdate userUpdated) {
        UserDTOToShow user = userService.update(userUpdated);
        return ResponseEntity.ok().body(user);
    }

    /**
     * Updates the role of a user.
     * 
     * @param userId the ID of the user whose role is to be updated.
     * @param role the UserDTOToUpdateRole object containing the new role.
     * @return a ResponseEntity containing the updated UserDTOToShow object.
     */
    @PutMapping("/{userId}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTOToShow> updateUserRole(@PathVariable Long userId, @RequestBody UserDTOToUpdateRole role) {
        UserDTOToShow updatedUser = userService.updateUserRole(userId, role.role());
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Deletes a user by ID.
     * 
     * @param id the ID of the user to delete.
     * @return a ResponseEntity containing the UserDTOToShow object of the deleted user.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTOToShow> delete(@PathVariable Long id) {
        UserDTOToShow userToDelete = userService.delete(id);
        return ResponseEntity.ok().body(userToDelete);
    }
}

