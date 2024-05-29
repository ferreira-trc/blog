package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.dtos.post.PostGetDTO;
import org.rumos.blog.model.dtos.post.PostMapDTO;
import org.rumos.blog.model.entities.Post;
import org.rumos.blog.repositories.PostRepository;
import org.rumos.blog.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    private PostRepository postRepository;
        
    public List<PostGetDTO> findAll() {
        List<Post> list = postRepository.findAll();
        List<PostGetDTO> listOfDTOs = new ArrayList<>();

        for (Post post : list) {
            listOfDTOs.add(PostMapDTO.convertoToGetDTO(post));
        }

        return listOfDTOs;
    }

    public PostGetDTO findById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post.get();
    }

    public List<PostGetDTO> findAllByCronOrder() {
        List<Post> list = postRepository.findAll();
        Comparator<Post> comparatorPostByPublicationDate = (post1, post2) -> post1.compareTo(post2); 
        list.sort(comparatorPostByPublicationDate);
        return list;
    }

    public Post add(Post post) {        
        return postRepository.save(post);
    }
    
    public Post update(Long postId, Post postUpdated) {
        Post postToUpdate = postRepository.getReferenceById(postId);
        updateDate(postToUpdate, postUpdated);
        return postRepository.save(postToUpdate);
    }

    private void updateDate(Post postToUpdate, Post postUpdated) {        
        postToUpdate.setTitle(postUpdated.getTitle());
        postToUpdate.setText(postUpdated.getText());       
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }
}
