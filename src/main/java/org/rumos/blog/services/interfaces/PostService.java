package org.rumos.blog.services.interfaces;

import java.util.List;

import org.rumos.blog.model.Post;

public interface PostService {
    public List<Post> findAll();
    public Post findById(Long id);
    public Post add(Post post);
    public Post update(Long postId, Post postUpdated);
    public void delete(Long id);
}
