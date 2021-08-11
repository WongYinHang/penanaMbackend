package com.penana.backend.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.penana.backend.Model.story_all;

import com.penana.backend.Dao.story_allRepostory;

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
public class story_allController {
    @Autowired
    private story_allRepostory story_allRepostory;

    @GetMapping("/story_all")
    public Collection<story_all> story_alls() {
        return story_allRepostory.findAll();
    }

    @GetMapping("/story_all/{id}")
    public ResponseEntity<?> getstory_all(@PathVariable Integer id) {
        Optional<story_all> story_all = story_allRepostory.findById(id);
        return story_all.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/story_all/getstory_genre_sid/{genre_sid}")
    public List<Object> getstory_genre_sid(@PathVariable Integer genre_sid) {

        return story_allRepostory.findBygenre_sid(genre_sid);
    }

    @GetMapping("/story_all/creator/{created_by}")
    public List<Object> getstory_created_by(@PathVariable Integer created_by) {

        return story_allRepostory.findBycreated_by(created_by);
    }

    @GetMapping("/story_all/popularity")
    public List<Object> getstorypopularity() {

        return story_allRepostory.findBypopularity();
    }

    @PostMapping("/story_all")
    public ResponseEntity<story_all> createstory_all(@Validated @RequestBody story_all story_all) throws Exception {
        story_all result = story_allRepostory.save(story_all);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/story_all/{id}")
    public ResponseEntity<story_all> updatestory_all(@PathVariable Integer id,
            @Validated @RequestBody story_all story_all) {

        story_all.setId(id);

        story_all result = story_allRepostory.saveAndFlush(story_all);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/story_all/{id}")
    public ResponseEntity<?> deletestory_all(@PathVariable Integer id) {

        story_allRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
