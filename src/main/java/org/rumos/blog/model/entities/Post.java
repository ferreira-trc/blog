package org.rumos.blog.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Represents a post entity in the blog application.
 * Extends {@link BaseEntity} to inherit fields such as id, createdAt, and modifiedAt.
 * Implements {@link Serializable} for serialization purposes.
 * Implements {@link Comparable} to provide natural ordering based on creation timestamp.
 */
@Entity
@Table(name = "posts")
public class Post extends BaseEntity implements Serializable, Comparable<Post> {
    private static final long serialVersionUID = 1L;

    private String title;

    @Column(length = 1000)
    private String text;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "post", cascade = { CascadeType.REMOVE })
    private Set<Comment> comments = new HashSet<>();

    /**
     * Default constructor.
     */
    public Post() {
    }

    /**
     * Constructor to initialize id, title, text, and category.
     *
     * @param id       The identifier of the post.
     * @param title    The title of the post.
     * @param text     The content/text of the post.
     * @param category The category of the post.
     */
    public Post(Long id, String title, String text, Category category) {
        super(id);
        this.title = title;
        this.text = text;
        this.category = category;
    }

    /**
     * Constructor to initialize id, title, text, category, and author.
     *
     * @param id       The identifier of the post.
     * @param title    The title of the post.
     * @param text     The content/text of the post.
     * @param category The category of the post.
     * @param author   The author (user) of the post.
     */
    public Post(Long id, String title, String text, Category category, User author) {
        this(id, title, text, category);
        this.author = author;
    }

    /**
     * Retrieves the title of the post.
     *
     * @return The title of the post.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the post.
     *
     * @param title The new title of the post.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the text/content of the post.
     *
     * @return The text/content of the post.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text/content of the post.
     *
     * @param text The new text/content of the post.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Retrieves the category of the post.
     *
     * @return The category of the post.
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the category of the post.
     *
     * @param category The new category of the post.
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Retrieves the author (user) of the post.
     *
     * @return The author (user) of the post.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Sets the author (user) of the post.
     *
     * @param author The new author (user) of the post.
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    /**
     * Retrieves the comments associated with the post.
     *
     * @return A set of comments associated with the post.
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the comments associated with the post.
     *
     * @param comments A set of comments to associate with the post.
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Returns a string representation of the post object.
     *
     * @return A string representation including title, text, category, and author of the post.
     */
    @Override
    public String toString() {
        return "Post [title=" + title + ", text=" + text + ", category=" + category + ", author=" + author + "]";
    }

    /**
     * Computes a hash code value for the post object.
     *
     * @return A hash code value based on the title, text, category, author, and comments of the post.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result + ((comments == null) ? 0 : comments.hashCode());
        return result;
    }

    /**
     * Checks if this post is equal to another object.
     *
     * @param obj The object to compare against.
     * @return {@code true} if the objects are equal based on title, text, category, author, and comments,
     *         otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (text == null) {
            if (other.text != null)
                return false;
        } else if (!text.equals(other.text))
            return false;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (comments == null) {
            if (other.comments != null)
                return false;
        } else if (!comments.equals(other.comments))
            return false;
        return true;
    }

    /**
     * Compares this post with another post based on creation timestamp.
     *
     * @param post The post to compare against.
     * @return A negative integer, zero, or a positive integer as this post is less than, equal to, or greater than
     *         the specified post based on creation timestamp.
     */
    @Override
    public int compareTo(Post post) {
        return getCreatedAt().compareTo(post.getCreatedAt());
    }
}

