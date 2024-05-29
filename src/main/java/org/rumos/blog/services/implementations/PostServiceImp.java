package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.dtos.maps.PostMapDTO;
import org.rumos.blog.model.dtos.post.PostDTOToShow;
import org.rumos.blog.model.dtos.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.post.PostDTOToUpdate;
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
        
    public List<PostDTOToShow> findAll() {
        List<Post> list = postRepository.findAll();
        List<PostDTOToShow> listOfDTOs = new ArrayList<>();

        for (Post post : list) {
            listOfDTOs.add(PostMapDTO.convertToGetDTO(post));
        }

        return listOfDTOs;
    }

    public PostDTOToShow findById(Long id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            return null;
        }

        PostDTOToShow postGetDTO = PostMapDTO.convertToGetDTO(post.get());
        return postGetDTO;
    }

    public List<PostDTOToShow> findAllByCronOrder() {
        List<Post> list = postRepository.findAllByOrderByCreatedAtDesc();  
        List<PostDTOToShow> listOfDTOs = new ArrayList<>();

        for (Post post : list) {
            listOfDTOs.add(PostMapDTO.convertToGetDTO(post));
        }
        return listOfDTOs;
    }

    public PostDTOToShow add(PostDTOToAdd postDTO) {
        User author = userRepository.findByUserName(postDTO.authorUserName());
        Post postToSave = PostMapDTO.convertToClass(postDTO);
        postToSave.setAuthor(author);

        Post postoToReturn = postRepository.save(postToSave);        

        return PostMapDTO.convertToGetDTO(postoToReturn);
    }
    
    public PostDTOToShow update(Long postId, PostDTOToUpdate postUpdated) {
        Post postToUpdate = postRepository.getReferenceById(postId);
        Post postToSave = PostMapDTO.convertToClass(postUpdated, postToUpdate);
        Post postToReturn = postRepository.save(postToSave);
        PostDTOToShow postDTO = PostMapDTO.convertToGetDTO(postToReturn);
        return postDTO;
    }    

    public PostDTOToShow delete(Long id) { 
        Optional<Post> postToDelete = postRepository.findById(id);
        postRepository.deleteById(id);

        PostDTOToShow postToReturn = PostMapDTO.convertToGetDTO(postToDelete.get());
        return postToReturn;
    }
}
