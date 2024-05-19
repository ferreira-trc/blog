package org.rumos.blog.services;

import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.Comment;
import org.rumos.blog.model.Post;
import org.rumos.blog.repositories.CommentRepository;
import org.rumos.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment findById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.get();
    }   
    
    public Comment add(Long postId,Comment comment) { 
        Optional<Post> commentedPost = postRepository.findById(postId);
        if (commentedPost.isPresent()) {
            comment.setPost(commentedPost.get());
            return commentRepository.save(comment);
        }     
        throw new EntityNotFoundException("Post not found");
    }
}
