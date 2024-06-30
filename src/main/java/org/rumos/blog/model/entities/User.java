package org.rumos.blog.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.rumos.blog.model.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Represents a user entity in the blog application.
 * Extends {@link BaseEntity} to inherit fields such as id, createdAt, and modifiedAt.
 * Implements {@link Serializable} for serialization purposes.
 * Implements {@link UserDetails} to integrate with Spring Security for user authentication and authorization.
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    private String password;
    private Role role;

    @OneToOne(cascade = { CascadeType.REMOVE })
    private Person person;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = { CascadeType.REMOVE })
    private Set<Post> posts = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = { CascadeType.REMOVE })
    private Set<Comment> comments = new HashSet<>();

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Constructor to initialize id, username, password, role, and associated person.
     *
     * @param id       The identifier of the user.
     * @param userName The username of the user.
     * @param password The password of the user.
     * @param role     The role of the user (admin or user).
     * @param person   The associated person entity of the user.
     */
    public User(Long id, String userName, String password, Role role, Person person) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.person = person;
    }

    /**
     * Retrieves the username of the user.
     *
     * @return The username of the user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user.
     *
     * @param userName The new username of the user.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The new password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the role of the user.
     *
     * @return The role of the user (admin or user).
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role of the user.
     *
     * @param role The new role of the user (admin or user).
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Retrieves the associated person entity of the user.
     *
     * @return The associated person entity of the user.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Sets the associated person entity of the user.
     *
     * @param person The new associated person entity of the user.
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Retrieves the posts authored by the user.
     *
     * @return A set of posts authored by the user.
     */
    public Set<Post> getPosts() {
        return posts;
    }

    /**
     * Sets the posts authored by the user.
     *
     * @param posts A set of posts to associate with the user.
     */
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    /**
     * Retrieves the comments made by the user.
     *
     * @return A set of comments made by the user.
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the comments made by the user.
     *
     * @param comments A set of comments to associate with the user.
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Retrieves the authorities granted to the user for authentication and authorization.
     * Administrators are granted both ROLE_ADMIN and ROLE_USER.
     * Regular users are granted only ROLE_USER.
     *
     * @return A collection of granted authorities for the user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    /**
     * Retrieves the username used for authentication.
     *
     * @return The username of the user.
     */
    @Override
    public String getUsername() {
        return getUserName();
    }

    /**
     * Indicates whether the user's account has not expired.
     *
     * @return {@code true} if the user's account is valid (i.e., not expired), otherwise {@code false}.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming no account expiration policy is implemented
    }

    /**
     * Indicates whether the user is not locked out of their account.
     *
     * @return {@code true} if the user's account is not locked, otherwise {@code false}.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming no account locking policy is implemented
    }

    /**
     * Indicates whether the user's credentials (password) are not expired.
     *
     * @return {@code true} if the user's credentials are valid (i.e., not expired), otherwise {@code false}.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming no credential expiration policy is implemented
    }

    /**
     * Indicates whether the user is enabled.
     *
     * @return {@code true} if the user is enabled, otherwise {@code false}.
     */
    @Override
    public boolean isEnabled() {
        return true; // Assuming all users are enabled by default
    }
}

