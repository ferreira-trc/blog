package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;
import org.rumos.blog.model.entities.Category;


public interface CategoryMapDTO {

    public Category convertToClass(CategoryDTOToAdd entityDTO);    
    public CategoryDTOToShow convertToDTO(Category entity);
}
