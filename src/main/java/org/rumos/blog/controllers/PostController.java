package org.rumos.blog.controllers;

import java.net.URI;
import java.util.List;

import org.rumos.blog.model.dtos.entities.post.PostDTOToAdd;
import org.rumos.blog.model.dtos.entities.post.PostDTOToShow;
import org.rumos.blog.model.dtos.entities.post.PostDTOToUpdate;
import org.rumos.blog.services.interfaces.PostService;
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
 * Controller class for handling operations related to posts.
 */
@RestController
@RequestMapping(value = "/post")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Retrieves all posts.
     *
     * @param order Optional parameter to specify ordering criteria (e.g., "cron" for cronological order)
     * @return ResponseEntity containing a list of PostDTOToShow objects
     */
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

    /**
     * Retrieves all posts by a specific author.
     *
     * @param authorId ID of the author whose posts are to be retrieved
     * @return ResponseEntity containing a list of PostDTOToShow objects
     */
    @GetMapping(value = "/author/{authorId}")
    public ResponseEntity<List<PostDTOToShow>> getAllByAuthor(@PathVariable Long authorId) {
        List<PostDTOToShow> list = postService.findAllByAuthor(authorId);
        return ResponseEntity.ok().body(list);
    }

    /**
     * Retrieves a post by its ID.
     *
     * @param id ID of the post to retrieve
     * @return ResponseEntity containing the PostDTOToShow object
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTOToShow> getById(@PathVariable Long id) {
        PostDTOToShow post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    /**
     * Adds a new post.
     *
     * @param postDTO PostDTOToAdd object containing the details of the post to add
     * @return ResponseEntity containing the created PostDTOToShow object
     */
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

    /**
     * Updates an existing post.
     *
     * @param id ID of the post to update
     * @param postUpdated PostDTOToUpdate object containing the updated details of the post
     * @return ResponseEntity containing the updated PostDTOToShow object
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDTOToShow> update(@PathVariable Long id, @RequestBody PostDTOToUpdate postUpdated) {
        PostDTOToShow postToReturn = postService.update(id, postUpdated);
        return ResponseEntity.ok().body(postToReturn);
    }

    /**
     * Deletes a post by its ID.
     *
     * @param id ID of the post to delete
     * @return ResponseEntity containing the deleted PostDTOToShow object
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostDTOToShow> delete(@PathVariable Long id) {
        PostDTOToShow postDeleted = postService.delete(id);
        return ResponseEntity.ok().body(postDeleted);
    }
}

