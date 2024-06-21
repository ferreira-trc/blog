package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.dtos.entities.user.UserDTOToRegister;
import org.rumos.blog.model.dtos.entities.user.UserDTOToShow;
import org.rumos.blog.model.dtos.entities.user.UserDTOToUpdate;
import org.rumos.blog.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping (value = "/user")
public class UserController {

    @Autowired
    private UserService userService;    

    @GetMapping
    public ResponseEntity<List<UserDTOToShow>> findAll() {
        List<UserDTOToShow> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTOToShow> getMethodName(@PathVariable Long id) {
        UserDTOToShow user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserDTOToShow> post(@RequestBody UserDTOToRegister userDTO) {
        UserDTOToShow user = userService.register(userDTO);

        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(user.id())
                    .toUri();

        return ResponseEntity.created(uri).body(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTOToShow> put(@PathVariable Long id, @RequestBody UserDTOToUpdate userUpdated) {
        UserDTOToShow user = userService.update(id, userUpdated);        
        return ResponseEntity.ok().body(user);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTOToShow> post(@PathVariable Long id) {
        UserDTOToShow userToDelete = userService.delete(id);
        return ResponseEntity.ok().body(userToDelete);
    }
}
