package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.Person;

public interface PersonService {
    public List<Person> findAll();
    public Person findById(Long id);
    public Person add(Person person);
}
