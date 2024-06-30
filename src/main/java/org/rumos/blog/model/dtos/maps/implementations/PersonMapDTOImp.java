package org.rumos.blog.model.dtos.maps.implementations;

import java.time.LocalDate;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.PersonMapDTO;
import org.rumos.blog.model.entities.Person;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link PersonMapDTO} interface that provides methods
 * to convert between {@link Person} entities and various DTOs representing
 * person data.
 */
@Component
public class PersonMapDTOImp implements PersonMapDTO {

    /**
     * Converts a {@link PersonDTOToRegister} DTO to a {@link Person} entity.
     *
     * @param entityDTO The {@link PersonDTOToRegister} DTO containing person data.
     * @return A {@link Person} entity populated with data from {@code entityDTO}.
     */
    @Override
    public Person convertToClass(PersonDTOToRegister entityDTO) {
        Person person = new Person();
        person.setName(entityDTO.name());
        person.setEmail(entityDTO.email());
        person.setBirthDay(LocalDate.parse(entityDTO.birthDay()));

        return person;
    }

    /**
     * Updates an existing {@link Person} entity with data from {@link PersonDTOToUpdate}.
     *
     * @param entityDTO The {@link PersonDTOToUpdate} DTO containing updated person data.
     * @param entity    The existing {@link Person} entity to be updated.
     * @return The updated {@link Person} entity.
     */
    @Override
    public Person convertToClass(PersonDTOToUpdate entityDTO, Person entity) {
        entity.setName(entityDTO.name());
        entity.setEmail(entityDTO.email());
        entity.setBirthDay(LocalDate.parse(entityDTO.birthDay()));

        return entity;
    }

    /**
     * Converts a {@link Person} entity to a {@link PersonDTOToShow} DTO.
     *
     * @param entity The {@link Person} entity to be converted.
     * @return A {@link PersonDTOToShow} DTO populated with data from {@code entity}.
     */
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

