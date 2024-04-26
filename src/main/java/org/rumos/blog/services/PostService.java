package org.rumos.blog.services;

import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.Post;
import org.rumos.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.get();
    }
}