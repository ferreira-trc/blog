package org.rumos.blog.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name= "persons")
public class Person extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;
        
    private String name;
    private LocalDate birthDay;    

    public Person() {
    }

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
