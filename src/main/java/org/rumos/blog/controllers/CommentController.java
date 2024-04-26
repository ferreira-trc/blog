package org.rumos.blog.controllers;

import java.util.List;

import org.rumos.blog.model.Comment;
import org.rumos.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
