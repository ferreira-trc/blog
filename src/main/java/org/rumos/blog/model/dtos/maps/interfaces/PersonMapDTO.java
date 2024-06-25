package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.person.PersonDTOToRegister;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToShow;
import org.rumos.blog.model.dtos.entities.person.PersonDTOToUpdate;
import org.rumos.blog.model.entities.Person;

public interface PersonMapDTO extends EntityMapDTO<Person, PersonDTOToShow, PersonDTOToRegister, PersonDTOToUpdate>{

}
