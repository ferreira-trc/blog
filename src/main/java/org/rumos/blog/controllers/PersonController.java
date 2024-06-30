package org.rumos.blog.controllers;

import java.util.List;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;
import org.rumos.blog.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling operations related to persons.
 * 
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Retrieves all persons. Requires ADMIN role.
     *
     * @return ResponseEntity containing a list of PersonDTOToShow objects
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PersonDTOToShow>> getAll() {
        List<PersonDTOToShow> list = personService.findAll();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Retrieves a person by their ID.
     *
     * @param id ID of the person to retrieve
     * @return ResponseEntity containing the PersonDTOToShow object
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTOToShow> getById(@PathVariable Long id) {
        PersonDTOToShow person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    }

    /**
     * Updates an existing person's details.
     *
     * @param id ID of the person to update
     * @param personUpdated PersonDTOToUpdate object containing updated details of the person
     * @return ResponseEntity containing the updated PersonDTOToShow object
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonDTOToShow> put(@PathVariable Long id, @RequestBody PersonDTOToUpdate personUpdated) {
        PersonDTOToShow person = personService.update(id, personUpdated);
        return ResponseEntity.ok().body(person);
    }
}

