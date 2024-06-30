package org.rumos.blog.model.dtos.entities.comment;

/**
 * A data transfer object (DTO) representing an update to a comment.
 * <p>
 * This DTO encapsulates the updated content of a comment. It is used to transfer
 * data between different layers of the application when updating existing comments.
 */
public record CommentDTOToUpdate(String commentContent ) {

}
