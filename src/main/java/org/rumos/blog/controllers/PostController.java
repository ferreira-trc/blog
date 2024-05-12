package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.Post;
import org.rumos.blog.model.User;
import org.rumos.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/post")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping    
    public ResponseEntity<List<Post>> findAll() {
        List<Post> list = postService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getMethodName(@PathVariable Long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
 
    @PostMapping
    public ResponseEntity<Post> post(@RequestBody Post post) {
        post = postService.add(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(post.getId()).toUri();        
        return ResponseEntity.created(uri).body(post);
    }
    
}
