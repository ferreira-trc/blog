package org.rumos.blog.model.dtos.entities.post;

/**
 * A data transfer object (DTO) representing a post to update.
 * <p>
 * This DTO encapsulates fields necessary to update details of a post,
 * including its ID, title, and text content.
 */
public record PostDTOToUpdate(Long id, String title, String text) {

}
