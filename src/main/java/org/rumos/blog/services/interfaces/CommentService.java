package org.rumos.blog.services.interfaces;

import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;

import java.util.List;

/**
 * Service interface for managing comments.
 */
public interface CommentService {

    /**
     * Retrieves all comments.
     *
     * @return A list of {@link CommentDTOToShow} representing all comments.
     */
    List<CommentDTOToShow> findAll();

    /**
     * Retrieves a comment by its ID.
     *
     * @param id The ID of the comment to retrieve.
     * @return The {@link CommentDTOToShow} representing the comment if found, otherwise null.
     */
    CommentDTOToShow findById(Long id);

    /**
     * Retrieves all comments of a specific post.
     *
     * @param postId The ID of the post to retrieve comments for.
     * @return A list of {@link CommentDTOToShow} representing all comments of the post.
     */
    List<CommentDTOToShow> findAllOfThePostId(Long postId);

    /**
     * Retrieves all comments of a specific post by chronological order.
     *
     * @param postId The ID of the post to retrieve comments for.
     * @return A list of {@link CommentDTOToShow} representing all comments of the post in chronological order.
     */
    List<CommentDTOToShow> findAllOfThePostIdByCronOrder(Long postId);

    /**
     * Adds a new comment to a post.
     *
     * @param postId  The ID of the post to add the comment to.
     * @param comment The {@link CommentDTOToAdd} object containing data for the new comment.
     * @return The {@link CommentDTOToShow} representing the added comment.
     */
    CommentDTOToShow add(Long postId, CommentDTOToAdd comment);

    /**
     * Updates an existing comment.
     *
     * @param id             The ID of the comment to update.
     * @param commentUpdated The {@link CommentDTOToUpdate} object containing updated data for the comment.
     * @return The {@link CommentDTOToShow} representing the updated comment.
     */
    CommentDTOToShow update(Long id, CommentDTOToUpdate commentUpdated);

    /**
     * Deletes a comment by its ID.
     *
     * @param id The ID of the comment to delete.
     * @return The {@link CommentDTOToShow} representing the deleted comment.
     */
    CommentDTOToShow delete(Long id);
}

