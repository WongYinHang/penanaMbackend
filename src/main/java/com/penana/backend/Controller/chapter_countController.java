package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.chapter_count;

import com.penana.backend.Dao.chapter_countRepostory;

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
public class chapter_countController {
    @Autowired
    private chapter_countRepostory chapter_countRepostory;

    @GetMapping("/chapter_count")
    public Collection<chapter_count> chapter_counts() {
        return chapter_countRepostory.findAll();
    }

    @GetMapping("/chapter_count/{id}")
    public ResponseEntity<?> getchapter_count(@PathVariable Integer id) {
        Optional<chapter_count> chapter_count = chapter_countRepostory.findById(id);
        return chapter_count.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/chapter_count")
    public ResponseEntity<chapter_count> createchapter_count(@Validated @RequestBody chapter_count chapter_count)
            throws Exception {
        chapter_count result = chapter_countRepostory.save(chapter_count);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/chapter_count/{id}")
    public ResponseEntity<chapter_count> updatechapter_count(@PathVariable Integer id,
            @Validated @RequestBody chapter_count chapter_count) {

        chapter_count.setId(id);

        chapter_count result = chapter_countRepostory.saveAndFlush(chapter_count);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/chapter_count/{id}")
    public ResponseEntity<?> deletechapter_count(@PathVariable Integer id) {

        chapter_countRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
