package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on {@link Category} entities.
 * Extends {@link JpaRepository} to inherit basic CRUD methods for entities.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    /**
     * Retrieves a {@link Category} entity by its category attribute.
     *
     * @param category The category string to search for.
     * @return The {@link Category} entity with the specified category, or {@code null} if not found.
     */
    Category findByCategory(String category);
}

