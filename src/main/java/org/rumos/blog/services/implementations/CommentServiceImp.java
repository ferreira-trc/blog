package org.rumos.blog.services.implementations;

import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.entities.Comment;
import org.rumos.blog.model.entities.Post;
import org.rumos.blog.repositories.CommentRepository;
import org.rumos.blog.repositories.PostRepository;
import org.rumos.blog.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImp implements CommentService{

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

    public Comment update(Long id, Comment commentUpdated) {
        Comment commentToUpdate = commentRepository.getReferenceById(id);
        updateDate(commentUpdated, commentToUpdate);
        return commentRepository.save(commentToUpdate);
    }

    private void updateDate(Comment commentUpdated, Comment commentToUpdate) {
        commentToUpdate.setText(commentUpdated.getText());
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);        
    }
    
}
