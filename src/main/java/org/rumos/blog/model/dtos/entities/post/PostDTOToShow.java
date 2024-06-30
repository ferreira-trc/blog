package org.rumos.blog.model.dtos.entities.post;

/**
 * A data transfer object (DTO) representing a post to show.
 * <p>
 * This DTO encapsulates fields necessary to display details of a post,
 * including its ID, title, text content, category, and the username of the author.
 */
public record PostDTOToShow(Long id, String title, String text, String category, String authorUserName) {
  
}
