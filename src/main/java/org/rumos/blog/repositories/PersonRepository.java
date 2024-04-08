package org.rumos.blog.repositories;

import org.rumos.blog.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long>{

}
