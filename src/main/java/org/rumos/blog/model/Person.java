package org.rumos.blog.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name= "persons")
public class Person extends EntityClass{
    
    private String name;
    private LocalDate birthDay;

    public Person(Long id, String name, LocalDate birthDay) {
        super(id);
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
    
}
