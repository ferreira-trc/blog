package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.dtos.post.PostDTOToShow;
import org.rumos.blog.model.dtos.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.post.PostDTOToUpdate;

public interface PostService {
    public List<PostDTOToShow> findAll();
    public List<PostDTOToShow> findAllByCronOrder();
    public PostDTOToShow findById(Long id);
    public PostDTOToShow add(PostDTOToAdd post);
    public PostDTOToShow update(Long postId, PostDTOToUpdate postUpdated);
    public PostDTOToShow delete(Long id);
}
