package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;

public interface PersonService {
    public List<PersonDTOToShow> findAll();
    public PersonDTOToShow findById(Long id);
    public PersonDTOToShow update(Long id, PersonDTOToUpdate personUpdated);
}
