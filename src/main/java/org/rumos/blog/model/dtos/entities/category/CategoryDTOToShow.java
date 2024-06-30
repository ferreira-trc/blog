package org.rumos.blog.model.dtos.entities.category;

/**
 * A data transfer object (DTO) representing a category to show.
 * <p>
 * This DTO encapsulates the category information with its identifier and category name.
 * It is used to transfer data between different layers of the application for displaying purposes.
 */
public record CategoryDTOToShow(Long id, String category) {

}
