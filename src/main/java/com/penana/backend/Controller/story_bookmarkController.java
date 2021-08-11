package com.penana.backend.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.penana.backend.Model.story_bookmark;

import com.penana.backend.Dao.story_bookmarkRepostory;

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
public class story_bookmarkController {
    @Autowired
    private story_bookmarkRepostory story_bookmarkRepostory;

    @GetMapping("/story_bookmark")
    public Collection<story_bookmark> story_bookmarks() {
        return story_bookmarkRepostory.findAll();
    }

    @GetMapping("/story_bookmark/{id}")
    public ResponseEntity<?> getstory_bookmark(@PathVariable Integer id) {
        Optional<story_bookmark> story_bookmark = story_bookmarkRepostory.findById(id);
        return story_bookmark.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/story_bookmark/user_id/{user_id}")
    public List<Object> getstory_bookmarkbyuser_id(@PathVariable Integer user_id) {
        return story_bookmarkRepostory.findByuser_id(user_id);
    }

    @PostMapping("/story_bookmark")
    public story_bookmark createstory_bookmark(@Validated @RequestBody story_bookmark story_bookmark) throws Exception {

        story_bookmark result = (com.penana.backend.Model.story_bookmark) story_bookmarkRepostory
                .findByuser_idAndStory_id(story_bookmark.getUser_id(), story_bookmark.getStory_id());
        System.out.println(result);
        if (result != null) {
            result.setMark_deleted("F");
            story_bookmarkRepostory.saveAndFlush(result);
            return result;
        } else {
            story_bookmark.setMark_deleted("F");
            story_bookmark resultCreate = story_bookmarkRepostory.save(story_bookmark);
            return resultCreate;
        }

    }

    @PostMapping("/story_bookmark/setdelete")
    public story_bookmark setdeletestory_bookmark(@Validated @RequestBody story_bookmark story_bookmark)
            throws Exception {

        story_bookmark result = (com.penana.backend.Model.story_bookmark) story_bookmarkRepostory
                .findByuser_idAndStory_id(story_bookmark.getUser_id(), story_bookmark.getStory_id());
        System.out.println(result);
        if (result != null) {
            result.setMark_deleted("T");
            story_bookmarkRepostory.saveAndFlush(result);
            return result;
        } else {
            story_bookmark.setMark_deleted("T");
            story_bookmark resultCreate = story_bookmarkRepostory.save(story_bookmark);
            return resultCreate;
        }

    }

    @PutMapping("/story_bookmark/{id}")
    public ResponseEntity<story_bookmark> updatestory_bookmark(@PathVariable Integer id,
            @Validated @RequestBody story_bookmark story_bookmark) {

        story_bookmark.setId(id);

        story_bookmark result = story_bookmarkRepostory.saveAndFlush(story_bookmark);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/story_bookmark/{id}")
    public ResponseEntity<?> deletestory_bookmark(@PathVariable Integer id) {

        story_bookmarkRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
