package com.penana.backend.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.penana.backend.Model.content;

import com.penana.backend.Dao.contentRepostory;

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
public class contentController {
    @Autowired
    private contentRepostory contentRepostory;

    @GetMapping("/content")
    public Collection<content> contents() {
        return contentRepostory.findAll();
    }

    @GetMapping("/content/{id}")
    public ResponseEntity<?> getcontent(@PathVariable Integer id) {
        Optional<content> content = contentRepostory.findById(id);
        return content.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/content/chapter_id/{chapter_id}")
    public List<Object> getcontent_chapter_id(@PathVariable Integer chapter_id) {

        return contentRepostory.findBychapter_id(chapter_id);
    }

    @PostMapping("/content")
    public ResponseEntity<content> createcontent(@Validated @RequestBody content content) throws Exception {
        content result = contentRepostory.save(content);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/content/{id}")
    public ResponseEntity<content> updatecontent(@PathVariable Integer id, @Validated @RequestBody content content) {
        Optional<content> Originalcontent = contentRepostory.findById(id);
        Originalcontent.get().setContent(content.toString());

        content result = contentRepostory.save(Originalcontent.get());
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/content/{id}")
    public ResponseEntity<?> deletecontent(@PathVariable Integer id) {

        contentRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
