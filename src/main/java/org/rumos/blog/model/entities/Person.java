package org.rumos.blog.model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents a person entity in the blog application.
 * Extends {@link BaseEntity} to inherit fields such as id, createdAt, and modifiedAt.
 */
@Entity
@Table(name = "persons")
public class Person extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    private LocalDate birthDay;

    /**
     * Default constructor.
     */
    public Person() {
    }

    /**
     * Constructor to initialize id, name, email, and birthDay.
     *
     * @param id       The identifier of the person.
     * @param name     The name of the person.
     * @param email    The email address of the person.
     * @param birthDay The date of birth of the person.
     */
    public Person(Long id, String name, String email, LocalDate birthDay) {
        super(id);
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
    }

    /**
     * Retrieves the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the email address of the person.
     *
     * @return The email address of the person.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the person.
     *
     * @param email The new email address of the person.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the date of birth of the person.
     *
     * @return The date of birth of the person.
     */
    public LocalDate getBirthDay() {
        return birthDay;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param birthDay The new date of birth of the person.
     */
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * Computes a hash code value for the person object.
     *
     * @return A hash code value based on the person's email address.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    /**
     * Checks if this person is equal to another object.
     *
     * @param obj The object to compare against.
     * @return {@code true} if the objects are equal based on the person's email address, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    /**
     * Returns a string representation of the person object.
     *
     * @return The name of the person as a string.
     */
    @Override
    public String toString() {
        return name;
    }

}

