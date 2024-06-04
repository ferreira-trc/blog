package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;
import org.rumos.blog.model.dtos.maps.interfaces.CategoryMapDTO;
import org.rumos.blog.model.entities.Category;
import org.rumos.blog.repositories.CategoryRepository;
import org.rumos.blog.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapDTO categoryMapDTO;

    @Override
    public List<CategoryDTOToShow> findAll() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDTOToShow> listDTOs = new ArrayList<>();

        for (Category category : list) {
            listDTOs.add(categoryMapDTO.convertToDTO(category));
        }

        return listDTOs;
    }

    @Override
    public CategoryDTOToShow findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isEmpty()) {
            return null;
        }

        CategoryDTOToShow categoryDTO = categoryMapDTO.convertToDTO(category.get());
        return categoryDTO;        
    }

    @Override
    public CategoryDTOToShow add(CategoryDTOToAdd post) {
        Category categoryToSave = categoryMapDTO.convertToClass(post);
        Category categoryToReturn = categoryRepository.save(categoryToSave);
        return categoryMapDTO.convertToDTO(categoryToReturn);

    }

    @Override
    public CategoryDTOToShow delete(Long id) {
        Optional<Category> categoryToDelete = categoryRepository.findById(id);

        if (categoryToDelete.isEmpty()) {
            throw new RuntimeException("The Category do not exist");
        }

        categoryRepository.delete(categoryToDelete.get());
        CategoryDTOToShow categoryDeleted = categoryMapDTO.convertToDTO(categoryToDelete.get());
        return categoryDeleted;
        
    }
    
}
