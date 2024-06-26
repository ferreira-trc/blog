package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;
import org.rumos.blog.model.entities.Person;
import org.rumos.blog.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;    

    @GetMapping   
    @PreAuthorize("hasRole('ADMIN')") 
    public ResponseEntity<List<PersonDTOToShow>> getAll() {
        List<PersonDTOToShow> list = personService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTOToShow> getById(@PathVariable Long id) {
        PersonDTOToShow person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    }
    
    }
    
    
}
