package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;
import org.rumos.blog.model.dtos.maps.interfaces.CategoryMapDTO;
import org.rumos.blog.model.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapDTOImp implements CategoryMapDTO{

    @Override
    public Category convertToClass(CategoryDTOToAdd entityDTO) {
        Category category = new Category();
        category.setCategory(entityDTO.category());
        return category;
    }

    @Override
    public CategoryDTOToShow convertToDTO(Category entity) {
        CategoryDTOToShow categoryDTO = new CategoryDTOToShow(entity.getId(), entity.getCategory());
        return categoryDTO;
    }

}
