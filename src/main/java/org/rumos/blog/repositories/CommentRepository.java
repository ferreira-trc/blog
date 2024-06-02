package org.rumos.blog.repositories;

import java.util.List;

import org.rumos.blog.model.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
     
    public List<Comment> findByPostId(Long postId);
    public List<Comment> findByPostIdOrderByCreatedAtDesc(Long postId);
}
