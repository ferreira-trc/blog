package org.rumos.blog.model.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Represents a category in the blog application.
 * Extends {@link BaseEntity} to inherit fields such as id, createdAt, and modifiedAt.
 */
@Entity
@Table(name = "categories")
public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String category;

    /**
     * Default constructor.
     */
    public Category() {
    }

    /**
     * Constructor to initialize id and category.
     *
     * @param id       The identifier of the category.
     * @param category The name or description of the category.
     */
    public Category(Long id, String category) {
        super(id);
        this.category = category;
    }

    /**
     * Retrieves the name or description of the category.
     *
     * @return The category name or description.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the name or description of the category.
     *
     * @param category The new category name or description.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Computes a hash code value for the category object.
     *
     * @return A hash code value based on the category name or description.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        return result;
    }

    /**
     * Checks if this category is equal to another object.
     *
     * @param obj The object to compare against.
     * @return {@code true} if the objects are equal based on category name or description, otherwise {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (category == null) {
            if (other.category != null)
                return false;
        } else if (!category.equals(other.category))
            return false;
        return true;
    }

    /**
     * Returns a string representation of the category object.
     *
     * @return The category name or description as a string.
     */
    @Override
    public String toString() {
        return category;
    }

}


