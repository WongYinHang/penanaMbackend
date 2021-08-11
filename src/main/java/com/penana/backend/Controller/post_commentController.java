package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.post_comment;

import com.penana.backend.Dao.post_commentRepostory;

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
public class post_commentController {
    @Autowired
    private post_commentRepostory post_commentRepostory;

    @GetMapping("/post_comment")
    public Collection<post_comment> post_comments() {
        return post_commentRepostory.findAll();
    }

    @GetMapping("/post_comment/{id}")
    public ResponseEntity<?> getpost_comment(@PathVariable Integer id) {
        Optional<post_comment> post_comment = post_commentRepostory.findById(id);
        return post_comment.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/post_comment")
    public ResponseEntity<post_comment> createpost_comment(@Validated @RequestBody post_comment post_comment)
            throws Exception {
        post_comment result = post_commentRepostory.save(post_comment);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/post_comment/{id}")
    public ResponseEntity<post_comment> updatepost_comment(@PathVariable Integer id,
            @Validated @RequestBody post_comment post_comment) {

        post_comment.setId(id);

        post_comment result = post_commentRepostory.saveAndFlush(post_comment);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/post_comment/{id}")
    public ResponseEntity<?> deletepost_comment(@PathVariable Integer id) {

        post_commentRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
