package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Repository interface for performing CRUD operations on {@link Comment} entities.
 * Extends {@link JpaRepository} to inherit basic CRUD methods for entities.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

    /**
     * Retrieves all {@link Comment} entities associated with a specific post ID.
     *
     * @param postId The ID of the post for which comments are to be retrieved.
     * @return A list of {@link Comment} entities associated with the specified post ID.
     */
    List<Comment> findByPostId(Long postId);

    /**
     * Retrieves all {@link Comment} entities associated with a specific post ID,
     * ordered by their creation timestamp in descending order.
     *
     * @param postId The ID of the post for which comments are to be retrieved.
     * @return A list of {@link Comment} entities associated with the specified post ID,
     *         ordered by creation timestamp in descending order.
     */
    List<Comment> findByPostIdOrderByCreatedAtDesc(Long postId);
}

