package org.rumos.blog.model.dtos.maps;

import org.rumos.blog.model.dtos.post.PostGetDTO;
import org.rumos.blog.model.dtos.post.PostPostDTO;
import org.rumos.blog.model.dtos.post.PostPutDTO;
import org.rumos.blog.model.entities.Post;

public class PostMapDTO {

    public static Post convertToClass(PostPostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.title());
        post.setText(postDTO.text());
        post.setCategory(postDTO.category());

        return post;
    }

    public static Post convertToClass(PostPutDTO postDTO, Post post) {        
        post.setTitle(postDTO.title());
        post.setText(postDTO.text());        

        return post;
    }

    public static PostGetDTO convertToGetDTO(Post post) {
        PostGetDTO postGetDTO = new PostGetDTO(post.getId(), post.getTitle(), post.getText(), post.getCategory(), post.getAuthor().getUserName());
        return postGetDTO;
    }

    
}
