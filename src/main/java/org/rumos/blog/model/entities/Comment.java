package org.rumos.blog.model.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents a comment made by a user on a specific post in the blog application.
 * Extends {@link BaseEntity} to inherit fields such as id, createdAt, and modifiedAt.
 */
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(length = 1000)
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User author;

    /**
     * Default constructor.
     */
    public Comment() {
    }

    /**
     * Constructor to initialize id, text, author, and post.
     *
     * @param id     The identifier of the comment.
     * @param text   The content of the comment.
     * @param author The user who authored the comment.
     * @param post   The post to which the comment is associated.
     */
    public Comment(Long id, String text, User author, Post post) {
        super(id);
        this.text = text;
        this.author = author;
        this.post = post;
    }

    /**
     * Retrieves the content of the comment.
     *
     * @return The text content of the comment.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the content of the comment.
     *
     * @param text The new text content of the comment.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Retrieves the user who authored the comment.
     *
     * @return The author (user) of the comment.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the user who authored the comment.
     *
     * @param author The new author (user) of the comment.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Retrieves the post to which the comment is associated.
     *
     * @return The post associated with the comment.
     */
    public Post getPost() {
        return post;
    }

    /**
     * Sets the post to which the comment is associated.
     *
     * @param post The new post associated with the comment.
     */
    public void setPost(Post post) {
        this.post = post;
    }

    /**
     * Computes a hash code value for the comment object.
     *
     * @return A hash code value based on the comment's text content.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        return result;
    }

    /**
     * Checks if this comment is equal to another object.
     *
     * @param obj The object to compare against.
     * @return {@code true} if the objects are equal based on the comment's text content, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comment other = (Comment) obj;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        return true;
    }

    /**
     * Returns a string representation of the comment object.
     *
     * @return The text content of the comment as a string.
     */
    @Override
    public String toString() {
        return text;
    }

}

