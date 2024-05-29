package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.post.PostGetDTO;
import org.rumos.blog.model.dtos.post.PostPostDTO;
import org.rumos.blog.model.dtos.post.PostPutDTO;
import org.rumos.blog.model.entities.Post;

public interface PostService {
    public List<PostGetDTO> findAll();
    public List<PostGetDTO> findAllByCronOrder();
    public PostGetDTO findById(Long id);
    public PostGetDTO add(PostPostDTO post);
    public PostGetDTO update(Long postId, PostPutDTO postUpdated);
    public void delete(Long id);
}
