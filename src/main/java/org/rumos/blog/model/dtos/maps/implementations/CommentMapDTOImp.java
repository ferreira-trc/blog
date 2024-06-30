package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.CommentMapDTO;
import org.rumos.blog.model.entities.Comment;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link CommentMapDTO} interface that provides methods to convert
 * between {@link CommentDTOToAdd}, {@link CommentDTOToUpdate}, {@link CommentDTOToShow},
 * and {@link Comment}.
 * <p>
 * This component handles the conversion of DTOs (Data Transfer Objects) to/from entities
 * for the {@link Comment} entity.
 */
@Component
public class CommentMapDTOImp implements CommentMapDTO {

    /**
     * Converts a {@link CommentDTOToAdd} object to a {@link Comment} entity.
     *
     * @param entityDTO the DTO object containing comment content
     * @return the corresponding {@link Comment} entity
     */
    @Override
    public Comment convertToClass(CommentDTOToAdd entityDTO) {
        Comment entity = new Comment();
        entity.setText(entityDTO.commentContent());
        entity.setAuthor(null); // Replace with actual author retrieval logic

        return entity;
    }

    /**
     * Updates a {@link Comment} entity using data from {@link CommentDTOToUpdate}.
     *
     * @param entityDTO the DTO object containing updated comment content
     * @param entity    the existing {@link Comment} entity to update
     * @return the updated {@link Comment} entity
     */
    @Override
    public Comment convertToClass(CommentDTOToUpdate entityDTO, Comment entity) {
        entity.setText(entityDTO.commentContent());

        return entity;
    }

    /**
     * Converts a {@link Comment} entity to a {@link CommentDTOToShow} object.
     *
     * @param entity the {@link Comment} entity
     * @return the corresponding {@link CommentDTOToShow} DTO object
     */
    @Override
    public CommentDTOToShow convertToDTO(Comment entity) {
        Long id = entity.getId();
        String postTitle = entity.getPost().getTitle();
        String commentContent = entity.getText();
        String authorUserName = entity.getAuthor().getUserName();
        CommentDTOToShow entityDTO = new CommentDTOToShow(id, postTitle, commentContent, authorUserName);

        return entityDTO;
    }
}
