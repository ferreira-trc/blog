package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.dtos.post.PostGetDTO;
import org.rumos.blog.model.dtos.post.PostMapDTO;
import org.rumos.blog.model.dtos.post.PostPostDTO;
import org.rumos.blog.model.entities.Post;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.repositories.PostRepository;
import org.rumos.blog.repositories.UserRepository;
import org.rumos.blog.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
        
    public List<PostGetDTO> findAll() {
        List<Post> list = postRepository.findAll();
        List<PostGetDTO> listOfDTOs = new ArrayList<>();

        for (Post post : list) {
            listOfDTOs.add(PostMapDTO.convertToGetDTO(post));
        }

        return listOfDTOs;
    }

    public PostGetDTO findById(Long id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            return null;
        }

        PostGetDTO postGetDTO = PostMapDTO.convertToGetDTO(post.get());
        return postGetDTO;
    }

    public List<PostGetDTO> findAllByCronOrder() {
        List<Post> list = postRepository.findAllByOrderByCreatedAtDesc();  
        List<PostGetDTO> listOfDTOs = new ArrayList<>();

        for (Post post : list) {
            listOfDTOs.add(PostMapDTO.convertToGetDTO(post));
        }
        return listOfDTOs;
    }

    public PostGetDTO add(PostPostDTO postDTO) {
        User author = userRepository.findByUserName(postDTO.authorUserName());
        Post postToSave = PostMapDTO.convertoToClass(postDTO);
        postToSave.setAuthor(author);

        Post postoToReturn = postRepository.save(postToSave);        

        return PostMapDTO.convertToGetDTO(postoToReturn);
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