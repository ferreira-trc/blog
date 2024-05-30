package org.rumos.blog.model.dtos.maps.implementations;

import org.rumos.blog.model.dtos.post.PostDTOToShow;
import org.rumos.blog.model.dtos.maps.interfaces.PostMapDTO;
import org.rumos.blog.model.dtos.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.post.PostDTOToUpdate;
import org.rumos.blog.model.entities.Post;

public class PostMapDTOImp implements PostMapDTO {
    
    @Override
    public Post convertToClass(PostDTOToAdd entityDTO) {
        Post entity = new Post();
        entity.setTitle(entityDTO.title());
        entity.setText(entityDTO.text());
        entity.setCategory(entityDTO.category());

        return entity;
    }

    @Override
    public Post convertToClass(PostDTOToUpdate entityDTO, Post entity) {        
        entity.setTitle(entityDTO.title());
        entity.setText(entityDTO.text());        

        return entity;
    }

    @Override
    public PostDTOToShow convertToDTO(Post entity) {
        Long id = entity.getId();
        String title = entity.getTitle();
        String text = entity.getText();
        String category = entity.getCategory();
        String authorUserName = entity.getAuthor().getUserName();
        PostDTOToShow entityDTO = new PostDTOToShow(id, title, text, category, authorUserName);

        return entityDTO;
    }

   

    
}
