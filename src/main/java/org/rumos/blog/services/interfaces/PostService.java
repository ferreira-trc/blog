package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.post.PostGetDTO;
import org.rumos.blog.model.entities.Post;

public interface PostService {
    public List<PostGetDTO> findAll();
    public List<PostGetDTO> findAllByCronOrder();
    public PostGetDTO findById(Long id);
    public Post add(Post post);
    public Post update(Long postId, Post postUpdated);
    public void delete(Long id);
}
