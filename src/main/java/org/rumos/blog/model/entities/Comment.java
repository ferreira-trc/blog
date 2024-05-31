package org.rumos.blog.model.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;
           
    @Column(length = 1000)
    private String text;   

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User author;

    public Comment() {
    }

    public Comment(Long id, String text, User author, Post post) {
        super(id);      
        this.text = text;        
        this.author = author;
        this.post = post;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }   
    
    public User getAuthor() {
        return author;
    }
    
    public void setAuthor(User author) {
        this.author = author;
    }
    
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }   

    

}
