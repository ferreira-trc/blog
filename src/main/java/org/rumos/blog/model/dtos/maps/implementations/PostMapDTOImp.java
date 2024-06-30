package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.entities.post.PostDTOToShow;
import org.rumos.blog.model.dtos.entities.post.PostDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.PostMapDTO;
import org.rumos.blog.model.entities.Category;
import org.rumos.blog.model.entities.Post;
import org.springframework.stereotype.Component;

/**
 * Implementation of the {@link PostMapDTO} interface that provides methods
 * to convert between {@link Post} entities and various DTOs representing
 * post data.
 */
@Component
public class PostMapDTOImp implements PostMapDTO {

    /**
     * Converts a {@link PostDTOToAdd} DTO to a {@link Post} entity.
     *
     * @param entityDTO The {@link PostDTOToAdd} DTO containing post data.
     * @return A {@link Post} entity populated with data from {@code entityDTO}.
     */
    @Override
    public Post convertToClass(PostDTOToAdd entityDTO) {
        Post entity = new Post();
        entity.setTitle(entityDTO.title());
        entity.setText(entityDTO.text());       

        return entity;
    }

    /**
     * Updates an existing {@link Post} entity with data from {@link PostDTOToUpdate}.
     *
     * @param entityDTO The {@link PostDTOToUpdate} DTO containing updated post data.
     * @param entity    The existing {@link Post} entity to be updated.
     * @return The updated {@link Post} entity.
     */
    @Override
    public Post convertToClass(PostDTOToUpdate entityDTO, Post entity) {        
        entity.setTitle(entityDTO.title());
        entity.setText(entityDTO.text());        

        return entity;
    }

    /**
     * Converts a {@link Post} entity to a {@link PostDTOToShow} DTO.
     *
     * @param entity The {@link Post} entity to be converted.
     * @return A {@link PostDTOToShow} DTO populated with data from {@code entity}.
     */
    @Override
    public PostDTOToShow convertToDTO(Post entity) {
        Long id = entity.getId();
        String title = entity.getTitle();
        String text = entity.getText();
        Category category = entity.getCategory();
        String authorUserName = entity.getAuthor().getUserName();
        PostDTOToShow entityDTO = new PostDTOToShow(id, title, text, category.getCategory(), authorUserName);

        return entityDTO;
    }   
    
}

