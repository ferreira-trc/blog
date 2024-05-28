package org.rumos.blog.services.implementations;

import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.entities.Person;
import org.rumos.blog.repositories.PersonRepository;
import org.rumos.blog.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImp implements PersonService{
   
    @Autowired
    private PersonRepository personRepository;
    
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }

    public Person add(Person person) {
        return personRepository.save(person);
    }

}
