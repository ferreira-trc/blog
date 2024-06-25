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


@RestController
@RequestMapping (value = "/user")
public class UserController {

    @Autowired
    private UserService userService;    

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserDTOToShow>> findAll() {
        List<UserDTOToShow> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTOToShow> getMethodName(@PathVariable Long id) {
        UserDTOToShow user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }    

    @PutMapping
    public ResponseEntity<UserDTOToShow> put(@RequestBody UserDTOToUpdate userUpdated) {
        UserDTOToShow user = userService.update(userUpdated);        
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{userId}/role")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserDTOToShow> updateUserRole(@PathVariable Long userId, @RequestBody UserDTOToUpdateRole role) {
        UserDTOToShow updatedUser = userService.updateUserRole(userId, role.role());
        return ResponseEntity.ok(updatedUser);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTOToShow> delete(@PathVariable Long id) {
        UserDTOToShow userToDelete = userService.delete(id);
        return ResponseEntity.ok().body(userToDelete);
    }
}
