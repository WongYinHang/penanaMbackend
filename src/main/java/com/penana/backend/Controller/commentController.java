package com.penana.backend.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.penana.backend.Model.comment;

import com.penana.backend.Dao.commentRepostory;

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
public class commentController {
    @Autowired
    private commentRepostory commentRepostory;

    @GetMapping("/comment")
    public Collection<comment> comments() {
        return commentRepostory.findAll();
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<?> getcomment(@PathVariable Integer id) {
        Optional<comment> comment = commentRepostory.findById(id);
        return comment.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/comment/count/{chapter_id}")
    public Integer countcommentbychapter_id(@PathVariable Integer chapter_id) {
        List<Object> comment = commentRepostory.findBychapter_id(chapter_id);

        return comment.size();
    }

    @GetMapping("/comment/user_id/{user_id}")
    public List<Object> getcomment_user_id(@PathVariable Integer user_id) {

        return commentRepostory.findByuser_id(user_id);
    }

    @GetMapping("/comment/chapter_id/{chapter_id}")
    public List<Object> getcomment_chapter_id(@PathVariable Integer chapter_id) {

        return commentRepostory.findBychapter_id(chapter_id);
    }

    @GetMapping("/comment/parent_id/{parent_id}")
    public List<Object> getcomment_parent_id(@PathVariable Integer parent_id) {

        return commentRepostory.findByparent_id(parent_id);
    }

    @PostMapping("/comment")
    public ResponseEntity<comment> createcomment(@Validated @RequestBody comment comment) throws Exception {

        comment result = commentRepostory.save(comment);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/comment/{id}")
    public ResponseEntity<comment> updatecomment(@PathVariable Integer id, @Validated @RequestBody comment comment) {

        comment.setId(id);

        comment result = commentRepostory.saveAndFlush(comment);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<?> deletecomment(@PathVariable Integer id) {

        commentRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
