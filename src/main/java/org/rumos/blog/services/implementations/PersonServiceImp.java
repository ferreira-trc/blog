package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.Exceptions.AccessDeniedException;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.PersonMapDTO;
import org.rumos.blog.model.entities.Person;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.repositories.PersonRepository;
import org.rumos.blog.services.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImp implements PersonService{
   
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapDTO personMapDTO;
    
    @Override
    public List<PersonDTOToShow> findAll() {
        List<Person> list = personRepository.findAll();
        List<PersonDTOToShow> listDTOs = new ArrayList<>();

        for (Person person : list) {
            listDTOs.add(personMapDTO.convertToDTO(person));
        }

        return listDTOs;
    }

    @Override
    public PersonDTOToShow findById(Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        
        if (!user.getPerson().getId().equals(id)) {
            throw new AccessDeniedException("You do not have permission to access this resource");
        }
        
        Optional<Person> person = personRepository.findById(id);

        if (person.isEmpty()) {
            throw new EntityNotFoundException("Person not found");
        }

        PersonDTOToShow personDTO = personMapDTO.convertToDTO(person.get());
        return personDTO;
    }

    @Override
    public PersonDTOToShow update(Long id, PersonDTOToUpdate personUpdated) {     
        User userLog = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
               
        if (!userLog.getPerson().getId().equals(id)) {
            throw new AccessDeniedException("You do not have permission to update this resource");
        }

        Optional<Person> person = personRepository.findByEmail(personUpdated.email());

        if (person.isEmpty()) {
            throw new EntityNotFoundException("Person not found");
        }

        Person personToSave = personMapDTO.convertToClass(personUpdated, userLog.getPerson());
        Person personToReturn = personRepository.save(personToSave);
        PersonDTOToShow PersonDTO = personMapDTO.convertToDTO(personToReturn);
        return PersonDTO;
    }

   

}
