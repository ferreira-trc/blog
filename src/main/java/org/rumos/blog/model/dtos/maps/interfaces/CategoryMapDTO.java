package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;
import org.rumos.blog.model.entities.Category;

/** * 
 *  Interface defining methods to convert between {@link org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd} ,
 * {@link CategoryDTOToShow}, and {@link Category}.
 * <p>
 * Implementations of this interface handle the conversion of DTOs (Data Transfer Objects)
 * to/from entities for the {@link Category} entity.
 */
public interface CategoryMapDTO {

    /**
     * Converts a {@link CategoryDTOToAdd} object to a {@link Category} entity.
     *
     * @param entityDTO the DTO object containing category information
     * @return the corresponding {@link Category} entity
     */
    Category convertToClass(CategoryDTOToAdd entityDTO);

    /**
     * Converts a {@link Category} entity to a {@link CategoryDTOToShow} object.
     *
     * @param entity the {@link Category} entity
     * @return the corresponding {@link CategoryDTOToShow} DTO object
     */
    CategoryDTOToShow convertToDTO(Category entity);
}
