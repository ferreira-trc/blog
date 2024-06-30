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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Controller class for handling operations related to comments on blog posts.
 */
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * Retrieves all comments.
     *
     * @return ResponseEntity containing a list of CommentDTOToShow objects
     */
    @GetMapping
    public ResponseEntity<List<CommentDTOToShow>> getAll() {
        List<CommentDTOToShow> list = commentService.findAll();
        return ResponseEntity.ok().body(list);
    }

    /**
     * Retrieves a comment by its ID.
     *
     * @param id ID of the comment to retrieve
     * @return ResponseEntity containing the CommentDTOToShow object
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTOToShow> getById(@PathVariable Long id) {
        CommentDTOToShow comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }

    /**
     * Retrieves all comments of a specific post.
     *
     * @param order Optional parameter to specify ordering of comments ("cron" for chronological order)
     * @param postId ID of the post to retrieve comments for
     * @return ResponseEntity containing a list of CommentDTOToShow objects
     */
    @GetMapping(value = "/post/{postId}")
    public ResponseEntity<List<CommentDTOToShow>> getByPost(@RequestParam(required = false) String order, @PathVariable Long postId) {
        List<CommentDTOToShow> comments;

        if ("cron".equals(order)) {
            comments = commentService.findAllOfThePostId(postId);
        } else {
            comments = commentService.findAllOfThePostIdByCronOrder(postId);
        }

        return ResponseEntity.ok().body(comments);
    }

    /**
     * Adds a new comment to a specific post.
     *
     * @param postId ID of the post to add the comment to
     * @param commentDTO CommentDTOToAdd object containing details of the comment to be added
     * @return ResponseEntity containing the added CommentDTOToShow object
     */
    @PostMapping(value = "/post/{postId}")
    public ResponseEntity<CommentDTOToShow> post(@PathVariable Long postId, @RequestBody CommentDTOToAdd commentDTO) {
        CommentDTOToShow comment = commentService.add(postId, commentDTO);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(comment.id())
                    .toUri();

        return ResponseEntity.created(uri).body(comment);
    }

    /**
     * Updates an existing comment.
     *
     * @param id ID of the comment to update
     * @param commentToUpdate CommentDTOToUpdate object containing updated details of the comment
     * @return ResponseEntity containing the updated CommentDTOToShow object
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<CommentDTOToShow> put(@PathVariable Long id, @RequestBody(required = true) CommentDTOToUpdate commentToUpdate) {
        CommentDTOToShow commentToReturn = commentService.update(id, commentToUpdate);
        return ResponseEntity.ok().body(commentToReturn);
    }

    /**
     * Deletes a comment by its ID.
     *
     * @param id ID of the comment to delete
     * @return ResponseEntity containing the deleted CommentDTOToShow object
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CommentDTOToShow> delete(@PathVariable Long id) {
        CommentDTOToShow commentDeleted = commentService.delete(id);
        return ResponseEntity.ok().body(commentDeleted);
    }
}

