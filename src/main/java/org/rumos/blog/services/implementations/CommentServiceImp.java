package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.Exceptions.AccessDeniedException;
import org.rumos.blog.model.Exceptions.ResourceNotFoundException;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.CommentMapDTO;
import org.rumos.blog.model.entities.Comment;
import org.rumos.blog.model.entities.Post;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.repositories.CommentRepository;
import org.rumos.blog.repositories.PostRepository;
import org.rumos.blog.repositories.UserRepository;
import org.rumos.blog.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentMapDTO commentMapDTO;

    @Override
    public List<CommentDTOToShow> findAll() {
        List<Comment> list = commentRepository.findAll();
        List<CommentDTOToShow> listOfDTOs = new ArrayList<>();

        for (Comment comment : list) {
            listOfDTOs.add(commentMapDTO.convertToDTO(comment));
        }
        
        return listOfDTOs;
    }
    
    @Override
    public List<CommentDTOToShow> findAllOfThePostId(Long postId) {
        List<Comment> list = commentRepository.findByPostId(postId);
        List<CommentDTOToShow> listOfDTOs = new ArrayList<>();
        
        for (Comment comment : list) {
            listOfDTOs.add(commentMapDTO.convertToDTO(comment));
        }
        
        return listOfDTOs;
    }
    
    @Override
    public List<CommentDTOToShow> findAllOfThePostIdByCronOrder(Long postId) {
        List<Comment> list = commentRepository.findByPostIdOrderByCreatedAtDesc(postId);
        List<CommentDTOToShow> listOfDTOs = new ArrayList<>();
        
        for (Comment comment : list) {
            listOfDTOs.add(commentMapDTO.convertToDTO(comment));
        }
        
        return listOfDTOs;
    }
   
    @Override
    public CommentDTOToShow findById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);

        if (comment.isEmpty()) {
            return null;
        }

        CommentDTOToShow commentDTOToShow = commentMapDTO.convertToDTO(comment.get());
        return commentDTOToShow;
    }   
    
    @Override
    public CommentDTOToShow add(Long postId, CommentDTOToAdd comment) { 
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Post> commentedPost = postRepository.findById(postId);

        if (commentedPost.isPresent()) {
            Comment commentToSave = commentMapDTO.convertToClass(comment);

            commentToSave.setPost(commentedPost.get());
            commentToSave.setAuthor(user);

            Comment commentSaved = commentRepository.save(commentToSave);

            return commentMapDTO.convertToDTO(commentSaved);
        }

        throw new EntityNotFoundException("Post not found");
    }
    
    @Override
    public CommentDTOToShow update(Long id, CommentDTOToUpdate commentUpdated) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Comment> commentOpt = commentRepository.findById(id);        

        if (commentOpt.isPresent()) {
            Comment commentToUpdate = commentOpt.get();            
            
            if (!commentToUpdate.getAuthor().getUserName().equals(user.getUserName())) {
                throw new AccessDeniedException("User not authorized to update this comment");
            }    
            
            commentToUpdate.setText(commentUpdated.commentContent());
            Comment commentToReturn = commentRepository.save(commentToUpdate);            
           
            CommentDTOToShow commentDTO = commentMapDTO.convertToDTO(commentToReturn);
            
            return commentDTO;
        } else {
            throw new ResourceNotFoundException("Comment not found");
        }
    }    
    
    @Override
    public CommentDTOToShow delete(Long id) {
        Optional<Comment> commentToDelete = commentRepository.findById(id);        
        commentRepository.deleteById(id);        

        CommentDTOToShow commentDeleted = commentMapDTO.convertToDTO(commentToDelete.get());
        return commentDeleted;
    }

}
