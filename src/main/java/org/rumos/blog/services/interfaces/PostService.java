package org.rumos.blog.services.interfaces;

import org.rumos.blog.model.dtos.entities.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.entities.post.PostDTOToShow;
import org.rumos.blog.model.dtos.entities.post.PostDTOToUpdate;

import java.util.List;

/**
 * Service interface for managing posts.
 */
public interface PostService {

    /**
     * Retrieves all posts.
     *
     * @return A list of {@link PostDTOToShow} representing all posts.
     */
    List<PostDTOToShow> findAll();

    /**
     * Retrieves all posts ordered by chronological order.
     *
     * @return A list of {@link PostDTOToShow} representing all posts ordered by chronological order.
     */
    List<PostDTOToShow> findAllByCronOrder();

    /**
     * Retrieves all posts by a specific author.
     *
     * @param authorId The ID of the author whose posts are to be retrieved.
     * @return A list of {@link PostDTOToShow} representing all posts authored by the specified author.
     */
    List<PostDTOToShow> findAllByAuthor(Long authorId);

    /**
     * Retrieves a post by its ID.
     *
     * @param id The ID of the post to retrieve.
     * @return The {@link PostDTOToShow} representing the post if found, otherwise null.
     */
    PostDTOToShow findById(Long id);

    /**
     * Adds a new post.
     *
     * @param post The {@link PostDTOToAdd} object containing data for the new post.
     * @return The {@link PostDTOToShow} representing the added post.
     */
    PostDTOToShow add(PostDTOToAdd post);

    /**
     * Updates an existing post.
     *
     * @param postId      The ID of the post to update.
     * @param postUpdated The {@link PostDTOToUpdate} object containing updated data for the post.
     * @return The {@link PostDTOToShow} representing the updated post.
     */
    PostDTOToShow update(Long postId, PostDTOToUpdate postUpdated);

    /**
     * Deletes a post by its ID.
     *
     * @param id The ID of the post to delete.
     * @return The {@link PostDTOToShow} representing the deleted post.
     */
    PostDTOToShow delete(Long id);
}

