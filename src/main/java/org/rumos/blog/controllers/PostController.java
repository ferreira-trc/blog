package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.dtos.entities.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.entities.post.PostDTOToShow;
import org.rumos.blog.model.dtos.entities.post.PostDTOToUpdate;
import org.rumos.blog.services.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<List<PostDTOToShow>> getAll(@RequestParam(required = false) String order) {
        List<PostDTOToShow> list;

        if ("cron".equals(order)) {
            list = postService.findAllByCronOrder();
        } else { 
            list = postService.findAll();
        }
         
        return ResponseEntity.ok().body(list);
    }   

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTOToShow> getById(@PathVariable Long id) {
        PostDTOToShow post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
 
    @PostMapping
    public ResponseEntity<PostDTOToShow> post(@RequestBody PostDTOToAdd postDTO) {
        PostDTOToShow post = postService.add(postDTO);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(post.id())
                    .toUri();

        return ResponseEntity.created(uri).body(post);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTOToShow> update(@PathVariable Long id, @RequestBody PostDTOToUpdate postUpdated) {
        PostDTOToShow postToReturn = postService.update(id, postUpdated);        
        return ResponseEntity.ok().body(postToReturn);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostDTOToShow> delete(@PathVariable Long id) {
        PostDTOToShow postDeleted = postService.delete(id);
        return ResponseEntity.ok().body(postDeleted);
    }


    
}
