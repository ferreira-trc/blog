package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.Comment;

public interface CommentService {

    public List<Comment> findAll();
    public Comment findById(Long id);
    public Comment add(Long postId,Comment comment);
    public Comment update(Long id, Comment commentUpdated);
    public void delete(Long id);
}
