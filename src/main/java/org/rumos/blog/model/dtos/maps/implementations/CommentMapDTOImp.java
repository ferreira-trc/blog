package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.CommentMapDTO;
import org.rumos.blog.model.entities.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapDTOImp implements CommentMapDTO{

    @Override
    public Comment convertToClass(CommentDTOToAdd entityDTO) {
        Comment entity = new Comment();
        entity.setPost(null);
        entity.setText(entityDTO.commentContent());
        entity.setAuthor(null);

        return entity;
    }

    @Override
    public Comment convertToClass(CommentDTOToUpdate entityDTO, Comment entity) {
        entity.setText(entityDTO.commentContent());

        return entity;
    }

    @Override
    public CommentDTOToShow convertToDTO(Comment entity) {
        Long id = entity.getId();
        String postTitle = entity.getPost().getTitle();
        String commentContent = entity.getText();
        String authorUserName = entity.getAuthor().getUserName();
        CommentDTOToShow entityDTO = new CommentDTOToShow(id, postTitle, commentContent, authorUserName);

        return entityDTO;
    }

}
