package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.Comment;
import org.rumos.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    
   
    private CommentService commentService;    

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }    

    @GetMapping    
    public ResponseEntity<List<Comment>> findAll() {
        List<Comment> list = commentService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> getMethodName(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }

    @PostMapping
    public ResponseEntity<Comment> post(@RequestParam Long postId, @RequestBody Comment comment) {
        comment = commentService.add(postId,comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(comment.getId()).toUri();        
        return ResponseEntity.created(uri).body(comment);
    }
}
