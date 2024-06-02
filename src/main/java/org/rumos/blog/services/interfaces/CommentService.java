package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;

public interface CommentService {

    public List<CommentDTOToShow> findAll();
    public CommentDTOToShow findById(Long id);
    public List<CommentDTOToShow> findAllOfThePostId(Long postId);
    public CommentDTOToShow add(Long postId, CommentDTOToAdd comment);
    public CommentDTOToShow update(Long id, CommentDTOToUpdate commentUpdated);
    public CommentDTOToShow delete(Long id);
}
