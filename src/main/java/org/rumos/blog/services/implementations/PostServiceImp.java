package org.rumos.blog.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rumos.blog.model.Exceptions.AccessDeniedException;
import org.rumos.blog.model.Exceptions.ResourceNotFoundException;
import org.rumos.blog.model.dtos.entities.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.entities.post.PostDTOToShow;
import org.rumos.blog.model.dtos.entities.post.PostDTOToUpdate;
import org.rumos.blog.model.dtos.maps.interfaces.PostMapDTO;
import org.rumos.blog.model.entities.Post;
import org.rumos.blog.model.entities.User;
import org.rumos.blog.repositories.CategoryRepository;
import org.rumos.blog.repositories.PostRepository;
import org.rumos.blog.repositories.UserRepository;
import org.rumos.blog.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostMapDTO postMapDTO;

   
        
    public List<PostDTOToShow> findAll() {
        List<Post> list = postRepository.findAll();
        List<PostDTOToShow> listOfDTOs = new ArrayList<>();

        for (Post post : list) {
            listOfDTOs.add(postMapDTO.convertToDTO(post));
        }

        return listOfDTOs;
    }

    public PostDTOToShow findById(Long id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            return null;
        }

        PostDTOToShow postGetDTO = postMapDTO.convertToDTO(post.get());
        return postGetDTO;
    }

    public List<PostDTOToShow> findAllByCronOrder() {
        List<Post> list = postRepository.findAllByOrderByCreatedAtDesc();  
        List<PostDTOToShow> listOfDTOs = new ArrayList<>();

        for (Post post : list) {
            listOfDTOs.add(postMapDTO.convertToDTO(post));
        }
        return listOfDTOs;
    }

    public PostDTOToShow add(PostDTOToAdd postDTO) {
        User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Post postToSave = postMapDTO.convertToClass(postDTO);
        postToSave.setAuthor(author);
        postToSave.setCategory(categoryRepository.findByCategory(postDTO.category()));

        Post postoToReturn = postRepository.save(postToSave);        

        return postMapDTO.convertToDTO(postoToReturn);
    }
    
    public PostDTOToShow update(Long postId, PostDTOToUpdate postUpdated) {
        Post postToUpdate = postRepository.getReferenceById(postId);
        Post postToSave = postMapDTO.convertToClass(postUpdated, postToUpdate);
        Post postToReturn = postRepository.save(postToSave);
        PostDTOToShow postDTO = postMapDTO.convertToDTO(postToReturn);
        return postDTO;
    }    

    public PostDTOToShow delete(Long id) { 
        Optional<Post> postToDelete = postRepository.findById(id);
        postRepository.deleteById(id);

        PostDTOToShow postToReturn = postMapDTO.convertToDTO(postToDelete.get());
        return postToReturn;
    }
}
