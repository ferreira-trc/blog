package org.rumos.blog.repositories;

import java.util.Optional;

import org.rumos.blog.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long>{

    public Optional<Person> findByEmail(String email);   

}
