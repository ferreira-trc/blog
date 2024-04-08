package org.rumos.blog.controllers;

import java.util.List;

import org.rumos.blog.model.Person;
import org.rumos.blog.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public ResponseEntity<List<Person>> findAll() {
        List<Person> list = personService.findAll();
        return ResponseEntity.ok().body(list);
    }
}
