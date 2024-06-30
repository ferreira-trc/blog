package org.rumos.blog.repositories;

import java.util.List;

import org.rumos.blog.model.entities.Post;
import org.rumos.blog.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>{

    public List<Post> findAllByOrderByCreatedAtDesc();
    public List<Post> findAllByAuthor(User author);
}
