package org.rumos.blog.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.rumos.blog.model.enums.Role;

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
    
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "username", nullable = false, unique = true)    
    private String userName;
    private String password;
    private Role role;

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

    public User(Long id,String email ,String userName, String password, Role role, Person person) {
        super(id);  
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.person = person;
    }   

    public static long getSerialversionuid() {
        return serialVersionUID;
    }     

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
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
    
    public Set<Comment> getComments() {
        return comments;
    }
    
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
