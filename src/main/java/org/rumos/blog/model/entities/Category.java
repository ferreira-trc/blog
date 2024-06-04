package org.rumos.blog.model.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name= "categories")
public class Category extends BaseEntity implements Serializable{
    private static final long serialVersionUID = 1L;

    private String category;

    public Category() {        
    }

    public Category(Long id, String category) {
        super(id);
        this.category = category;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
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

    @Override
    public String toString() {
        return category;
    }

    
}
