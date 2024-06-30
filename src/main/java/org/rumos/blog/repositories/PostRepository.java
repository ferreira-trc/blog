package org.rumos.blog.repositories;

import org.rumos.blog.model.entities.Post;
import org.rumos.blog.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on {@link Post} entities.
 * Extends {@link JpaRepository} to inherit basic CRUD methods for entities.
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    /**
     * Retrieves all posts from the database ordered by their creation timestamp in descending order.
     *
     * @return A list of {@link Post} entities ordered by creation timestamp descending.
     */
    List<Post> findAllByOrderByCreatedAtDesc();

    /**
     * Retrieves all posts authored by the given user.
     *
     * @param author The {@link User} entity representing the author of the posts.
     * @return A list of {@link Post} entities authored by the specified user.
     */
    List<Post> findAllByAuthor(User author);
}

