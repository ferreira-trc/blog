package org.rumos.blog.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "posts")
public class Post extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;
        
    private String title;
    @Column(length = 1000)
    private String text;    
    private String category;
    
    @ManyToOne
    private User author;
    
    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE})
    private Set<Comment> comments = new HashSet<>();

    public Post() {
    }

    public Post(Long id, String title, String text, LocalDateTime dateOfPublication, String category) {
        super(id);        
        this.title = title;
        this.text = text;        
        this.category = category;
    }

    public Post(Long id, String title, String text, LocalDateTime dateOfPublication, String category, User author) {
        this(id, title, text, dateOfPublication, category);
        this.author = author;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }    

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    
    
    
}
