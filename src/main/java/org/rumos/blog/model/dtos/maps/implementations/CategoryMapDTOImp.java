package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;
import org.rumos.blog.model.dtos.maps.interfaces.CategoryMapDTO;
import org.rumos.blog.model.entities.Category;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link CategoryMapDTO} interface that provides methods
 * to convert between {@link CategoryDTOToAdd}, {@link CategoryDTOToShow}, and {@link Category}.
 * <p>
 * This component handles the conversion of DTOs (Data Transfer Objects) to/from entities,
 * specifically for the {@link Category} entity and its corresponding DTOs.
 */
@Component
public class CategoryMapDTOImp implements CategoryMapDTO {

    /**
     * Converts a {@link CategoryDTOToAdd} object to a {@link Category} entity.
     *
     * @param entityDTO the DTO object containing category information
     * @return the corresponding {@link Category} entity
     */
    @Override
    public Category convertToClass(CategoryDTOToAdd entityDTO) {
        Category category = new Category();
        category.setCategory(entityDTO.category());
        return category;
    }

    /**
     * Converts a {@link Category} entity to a {@link CategoryDTOToShow} object.
     *
     * @param entity the {@link Category} entity
     * @return the corresponding {@link CategoryDTOToShow} DTO object
     */
    @Override
    public CategoryDTOToShow convertToDTO(Category entity) {
        CategoryDTOToShow categoryDTO = new CategoryDTOToShow(entity.getId(), entity.getCategory());
        return categoryDTO;
    }

}

