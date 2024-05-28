package org.rumos.blog.model;

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

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "createdAt", nullable = false)
    @CreationTimestamp
    @Comment("Time at entity was created")
    private Timestamp createdAt;

    @Column(name = "modifiedAt", nullable = false)
    @UpdateTimestamp
    @Comment("Time at entity was updated")
    private Timestamp modifiedAt;
    
    public BaseEntity() {
    }     

    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity(Long id, Timestamp createdAt) {
        this(id);
        this.createdAt = createdAt;       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    

}
