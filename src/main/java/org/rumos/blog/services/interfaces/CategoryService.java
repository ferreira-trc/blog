package org.rumos.blog.services.interfaces;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;

import java.util.List;

/**
 * Service interface for managing categories.
 */
public interface CategoryService {

    /**
     * Retrieves all categories.
     *
     * @return A list of {@link CategoryDTOToShow} representing all categories.
     */
    List<CategoryDTOToShow> findAll();

    /**
     * Retrieves a category by its ID.
     *
     * @param id The ID of the category to retrieve.
     * @return The {@link CategoryDTOToShow} representing the category if found, otherwise null.
     */
    CategoryDTOToShow findById(Long id);

    /**
     * Adds a new category.
     *
     * @param categoryDTO The {@link CategoryDTOToAdd} object containing data for the new category.
     * @return The {@link CategoryDTOToShow} representing the added category.
     */
    CategoryDTOToShow add(CategoryDTOToAdd categoryDTO);

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to delete.
     * @return The {@link CategoryDTOToShow} representing the deleted category.
     */
    CategoryDTOToShow delete(Long id);
}

