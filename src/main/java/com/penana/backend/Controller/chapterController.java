package com.penana.backend.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.penana.backend.Model.chapter;

import com.penana.backend.Dao.chapterRepostory;

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
public class chapterController {
    @Autowired
    private chapterRepostory chapterRepostory;

    @GetMapping("/chapter")
    public Collection<chapter> chapters() {
        return chapterRepostory.findAll();
    }

    @GetMapping("/chapter/{id}")
    public ResponseEntity<?> getchapter(@PathVariable Integer id) {
        Optional<chapter> chapter = chapterRepostory.findById(id);
        return chapter.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/chapter/story_id/{story_id}")
    public List<Object> getchapter_story_id(@PathVariable Integer story_id) {

        return chapterRepostory.findBystory_id(story_id);
    }

    @PostMapping("/chapter")
    public ResponseEntity<chapter> createchapter(@Validated @RequestBody chapter chapter) throws Exception {
        chapter result = chapterRepostory.save(chapter);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/chapter/{id}")
    public ResponseEntity<chapter> updatechapter(@PathVariable Integer id, @Validated @RequestBody chapter chapter) {

        chapter.setId(id);

        chapter result = chapterRepostory.saveAndFlush(chapter);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/chapter/{id}")
    public ResponseEntity<?> deletechapter(@PathVariable Integer id) {

        chapterRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
