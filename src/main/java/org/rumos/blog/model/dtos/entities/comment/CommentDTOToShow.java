package org.rumos.blog.model.dtos.entities.comment;

/**
 * A data transfer object (DTO) representing a comment to show.
 * <p>
 * This DTO encapsulates the essential information of a comment, including its
 * ID, associated post title, content, and the author's username. It is used
 * to transfer data between different layers of the application for displaying comments.
 */
public record CommentDTOToShow(Long id, String postTitle, String commentContent, String authorUserName) {

}
