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
        PostGetDTO postGetDTO = new PostGetDTO(post.getId(), post.getTitle(), post.getText(), post.getCategory(), post.getAuthor().getUserName());
        return postGetDTO;
    }

    
}
