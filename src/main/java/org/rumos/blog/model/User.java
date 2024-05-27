package org.rumos.blog.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;    
    
    @Column(name = "username", nullable = false, unique = true)    
    private String userName;
    private String password;
    private String role;

    @OneToOne(cascade = {CascadeType.REMOVE})
    private Person person;
    
    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = {CascadeType.REMOVE})
    private Set<Post> posts = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.REMOVE})
    private Set<Comment> comments = new HashSet<>();

    public User() {
    }

    public User(Long id, String userName, String password, String role, Person person) {
        super(id);  
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.person = person;
    }   

    public static long getSerialversionuid() {
        return serialVersionUID;
    }    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

}
