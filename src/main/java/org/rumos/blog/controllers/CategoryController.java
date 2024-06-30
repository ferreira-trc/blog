package org.rumos.blog.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.dtos.entities.category.CategoryDTOToAdd;
import org.rumos.blog.model.dtos.entities.category.CategoryDTOToShow;
import org.rumos.blog.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller class for handling operations related to blog categories.
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * Endpoint to retrieve all categories.
     *
     * @return ResponseEntity containing a list of CategoryDTOToShow objects
     */
    @GetMapping
    public ResponseEntity<List<CategoryDTOToShow>> getAll() {
        List<CategoryDTOToShow> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    /**
     * Endpoint to add a new category.
     *
     * @param categoryDTO CategoryDTOToAdd object containing details of the category to be added
     * @return ResponseEntity containing the added CategoryDTOToShow object
     */
    @PostMapping
    public ResponseEntity<CategoryDTOToShow> post(@RequestBody CategoryDTOToAdd categoryDTO) {   
        CategoryDTOToShow category = categoryService.add(categoryDTO);
        
        // Building URI for newly created resource
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(category.id())
                    .toUri();

        return ResponseEntity.created(uri).body(category);
    }

    /**
     * Endpoint to delete a category by its ID.
     *
     * @param id ID of the category to be deleted
     * @return ResponseEntity containing the deleted CategoryDTOToShow object
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoryDTOToShow> delete(@PathVariable Long id) {
        CategoryDTOToShow categoryDeleted = categoryService.delete(id);
        return ResponseEntity.ok().body(categoryDeleted);
    }
}

