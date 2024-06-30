package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;
import org.rumos.blog.model.entities.Comment;

/**
 * Interface defining methods to map between {@link Comment} entity and its DTO representations.
 * This interface extends {@link EntityMapDTO} specifying types for {@link Comment}, {@link CommentDTOToShow},
 * {@link CommentDTOToAdd}, and {@link CommentDTOToUpdate}.
 */
public interface CommentMapDTO extends EntityMapDTO<Comment, CommentDTOToShow, CommentDTOToAdd, CommentDTOToUpdate> {
    
}
