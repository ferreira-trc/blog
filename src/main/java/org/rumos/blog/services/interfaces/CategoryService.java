package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;



public interface CategoryService {

    public List<CategoryDTOToShow> findAll();
    public CategoryDTOToShow findById(Long id);
    public CategoryDTOToShow add(CategoryDTOToAdd post);    
    public CategoryDTOToShow delete(Long id);
}
