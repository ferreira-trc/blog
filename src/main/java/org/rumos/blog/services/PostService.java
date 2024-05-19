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

    public Post add(Post post) {        
        return postRepository.save(post);
    }
    /*
     * need more logic.
     * if the category change the comments while be deleted
     */
    public Post update(Long postId, Post postUpdated) {
        Post postToUpdate = postRepository.getReferenceById(postId);
        postToUpdate.setTitle(postUpdated.getTitle());
        postToUpdate.setText(postUpdated.getText());
        postToUpdate.setCategory(postUpdated.getCategory());

        return postRepository.save(postToUpdate);

    }
}
