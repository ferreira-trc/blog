package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.dtos.entities.comment.CommentDTOToAdd;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToShow;
import org.rumos.blog.model.dtos.entities.comment.CommentDTOToUpdate;
import org.rumos.blog.services.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    
   
    @Autowired
    private CommentService commentService;    

    @GetMapping    
    public ResponseEntity<List<CommentDTOToShow>> findAll() {
        List<CommentDTOToShow> list = commentService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTOToShow> getById(@PathVariable Long id) {
        CommentDTOToShow comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }

    @PostMapping(value = "post/{postId}")
    public ResponseEntity<CommentDTOToShow> post(@PathVariable Long postId, @RequestBody CommentDTOToAdd commentDTO) {
        
        CommentDTOToShow comment = commentService.add(postId,commentDTO);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(comment.id())
                    .toUri();

        return ResponseEntity.created(uri).body(comment);
    }

    @PutMapping( value = "/{id}")
    public ResponseEntity<CommentDTOToShow> put(@PathVariable Long id, @RequestBody(required = true) CommentDTOToUpdate commentToUpdate) {
        CommentDTOToShow commentToReturn = commentService.update(id, commentToUpdate);        
        return ResponseEntity.ok().body(commentToReturn);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CommentDTOToShow> delete(@PathVariable Long id) {
        CommentDTOToShow commentDeleted = commentService.delete(id);
        return ResponseEntity.ok().body(commentDeleted);
    }
}
