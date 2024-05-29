package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.dtos.post.PostGetDTO;
import org.rumos.blog.model.dtos.post.PostPostDTO;
import org.rumos.blog.model.entities.Post;
import org.rumos.blog.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;    

    @GetMapping    
    public ResponseEntity<List<PostGetDTO>> getAll(@RequestParam(required = false) String order) {
        List<PostGetDTO> list;

        if ("cron".equals(order)) {
            list = postService.findAllByCronOrder();
        } else { 
            list = postService.findAll();
        }
         
        return ResponseEntity.ok().body(list);
    }   

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostGetDTO> getById(@PathVariable Long id) {
        PostGetDTO post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
 
    @PostMapping
    public ResponseEntity<PostGetDTO> post(@RequestBody PostPostDTO postDTO) {
        PostGetDTO post = postService.add(postDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(post.getId()).toUri();        
        return ResponseEntity.created(uri).body(post);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @RequestBody Post post) {
        post = postService.update(id, post);        
        return ResponseEntity.ok().body(post);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }


    
}
