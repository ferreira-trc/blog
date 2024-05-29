package org.rumos.blog.model.dtos.maps;

import org.rumos.blog.model.dtos.post.PostDTOToShow;
import org.rumos.blog.model.dtos.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.post.PostDTOToUpdate;
import org.rumos.blog.model.entities.Post;

public class PostMapDTO {

    public static Post convertToClass(PostDTOToAdd postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.title());
        post.setText(postDTO.text());
        post.setCategory(postDTO.category());

        return post;
    }

    public static Post convertToClass(PostDTOToUpdate postDTO, Post post) {        
        post.setTitle(postDTO.title());
        post.setText(postDTO.text());        

        return post;
    }

    public static PostDTOToShow convertToGetDTO(Post post) {
        PostDTOToShow postGetDTO = new PostDTOToShow(post.getId(), post.getTitle(), post.getText(), post.getCategory(), post.getAuthor().getUserName());
        return postGetDTO;
    }

    
}
