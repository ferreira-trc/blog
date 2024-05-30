package org.rumos.blog.model.dtos.maps.interfaces;

import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;
import org.rumos.blog.model.entities.Comment;

public interface CommentMapDTO extends EntityMapDTO<Comment, CommentDTOToShow, CommentDTOToAdd, CommentDTOToUpdate> {

}
