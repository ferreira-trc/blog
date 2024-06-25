package org.rumos.blog.model.dtos.maps.implementations;

import java.time.LocalDate;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.PersonMapDTO;
import org.rumos.blog.model.entities.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapDTOImp implements PersonMapDTO{

    @Override
    public Person convertToClass(PersonDTOToRegister entityDTO) {
        Person person = new Person();
        person.setName(entityDTO.name());
        person.setEmail(entityDTO.email());
        person.setBirthDay(LocalDate.parse(entityDTO.birthDay()));

        return person;
    }

    @Override
    public Person convertToClass(PersonDTOToUpdate entityDTO, Person entity) {
        entity.setName(entityDTO.name());
        entity.setEmail(entityDTO.email());
        entity.setBirthDay(LocalDate.parse(entityDTO.birthDay()));

        return entity;
    }

    @Override
    public PersonDTOToShow convertToDTO(Person entity) {
        Long id = entity.getId();
        String name = entity.getName();
        String email = entity.getEmail();
        String birthDay = entity.getBirthDay().toString();
        PersonDTOToShow entityDTO = new PersonDTOToShow(id, name, email, birthDay);

        return entityDTO;
    }

   

}
