package org.rumos.blog.model.dtos.entities.comment;

/**
 * A data transfer object (DTO) representing a comment to add.
 * <p>
 * This DTO encapsulates the content of a comment and is used to transfer data
 * between different layers of the application for adding new comments.
 */
public record CommentDTOToAdd(String commentContent) {
    
}
