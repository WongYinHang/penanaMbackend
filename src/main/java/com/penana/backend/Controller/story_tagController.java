package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.story_tag;

import com.penana.backend.Dao.story_tagRepostory;

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
public class story_tagController {
    @Autowired
    private story_tagRepostory story_tagRepostory;

    @GetMapping("/story_tag")
    public Collection<story_tag> story_tags() {
        return story_tagRepostory.findAll();
    }

    @GetMapping("/story_tag/{id}")
    public ResponseEntity<?> getstory_tag(@PathVariable Integer id) {
        Optional<story_tag> story_tag = story_tagRepostory.findById(id);
        return story_tag.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/story_tag")
    public ResponseEntity<story_tag> createstory_tag(@Validated @RequestBody story_tag story_tag) throws Exception {
        story_tag result = story_tagRepostory.save(story_tag);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/story_tag/{id}")
    public ResponseEntity<story_tag> updatestory_tag(@PathVariable Integer id,
            @Validated @RequestBody story_tag story_tag) {

        story_tag.setId(id);

        story_tag result = story_tagRepostory.saveAndFlush(story_tag);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/story_tag/{id}")
    public ResponseEntity<?> deletestory_tag(@PathVariable Integer id) {

        story_tagRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
