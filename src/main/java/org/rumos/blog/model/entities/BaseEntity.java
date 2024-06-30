package org.rumos.blog.model.entities;

import java.sql.Timestamp;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Abstract base class for entities in the application.
 * Provides common fields like id, createdAt, and modifiedAt.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "createdAt", nullable = false)
    @CreationTimestamp
    @Comment("Time at which the entity was created")
    private Timestamp createdAt;

    @Column(name = "modifiedAt", nullable = false)
    @UpdateTimestamp
    @Comment("Time at which the entity was last modified")
    private Timestamp modifiedAt;
    
    /**
     * Default constructor.
     */
    public BaseEntity() {
    }     

    /**
     * Constructor with id parameter.
     * 
     * @param id The id of the entity.
     */
    public BaseEntity(Long id) {
        this.id = id;
    }    

    /**
     * Retrieves the id of the entity.
     * 
     * @return The id of the entity.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the entity.
     * 
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the timestamp when the entity was created.
     * 
     * @return The timestamp of creation.
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the timestamp when the entity was created.
     * 
     * @param createdAt The timestamp of creation to set.
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Retrieves the timestamp when the entity was last modified.
     * 
     * @return The timestamp of last modification.
     */
    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    /**
     * Sets the timestamp when the entity was last modified.
     * 
     * @param modifiedAt The timestamp of last modification to set.
     */
    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}

