package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.post;

import com.penana.backend.Dao.postRepostory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class postController {
    @Autowired
    private postRepostory postRepostory;

    @GetMapping("/post")
    public Collection<post> posts() {
        return postRepostory.findAll();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> getpost(@PathVariable Integer id) {
        Optional<post> post = postRepostory.findById(id);
        return post.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/post")
    public ResponseEntity<post> createpost(@Validated @RequestBody post post) throws Exception {
        post result = postRepostory.save(post);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<post> updatepost(@PathVariable Integer id, @Validated @RequestBody post post) {

        post.setId(id);

        post result = postRepostory.saveAndFlush(post);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deletepost(@PathVariable Integer id) {

        postRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
