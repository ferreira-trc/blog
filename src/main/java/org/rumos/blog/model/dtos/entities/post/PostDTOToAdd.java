package org.rumos.blog.model.dtos.entities.post;

/**
 * A data transfer object (DTO) representing a post to add.
 * <p>
 * This DTO encapsulates fields necessary to create a new post,
 * including its title, text content, and category.
 */
public record PostDTOToAdd(String title, String text, String category) {
} 
 