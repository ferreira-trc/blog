package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;
import org.rumos.blog.model.entities.Person;

/**
 * Interface defining methods to map between a Person entity and its DTO representations for showing,
 * registering, and updating.
 */
public interface PersonMapDTO extends EntityMapDTO<Person, PersonDTOToShow, PersonDTOToRegister, PersonDTOToUpdate> {

}

