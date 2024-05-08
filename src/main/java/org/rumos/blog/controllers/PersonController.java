package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.Person;
import org.rumos.blog.model.User;
import org.rumos.blog.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping(value = "/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping    
    public ResponseEntity<List<Person>> findAll() {
        List<Person> list = personService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> getMethodName(@PathVariable Long id) {
        Person person = personService.findById(id);
        return ResponseEntity.ok().body(person);
    }
    
    @PostMapping
    public ResponseEntity<Person> post(@RequestBody Person person) {
        person = personService.add(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(person.getId()).toUri();        
        return ResponseEntity.created(uri).body(person);
    }
    
    
}
