package org.rumos.blog.model.dtos.post;

import org.rumos.blog.model.entities.Post;

public class PostMapDTO {

    public static Post convertoToClass(PostPostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.title());
        post.setText(postDTO.text());
        post.setCategory(postDTO.category());

        return post;
    }

    public static PostGetDTO convertToGetDTO(Post post) {
        PostGetDTO postGetDTO = new PostGetDTO();
        postGetDTO.setId(post.getId());
        postGetDTO.setTitle(post.getTitle());
        postGetDTO.setText(post.getText());
        postGetDTO.setCategory(post.getCategory());
        postGetDTO.setAuthorUserName(post.getAuthor().getUserName());

        return postGetDTO;
    }

    
}
