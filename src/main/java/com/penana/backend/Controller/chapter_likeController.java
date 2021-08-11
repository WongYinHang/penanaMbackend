package com.penana.backend.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.penana.backend.Model.chapter_like;

import com.penana.backend.Dao.chapter_likeRepostory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
public class chapter_likeController {
    @Autowired
    private chapter_likeRepostory chapter_likeRepostory;

    @GetMapping("/chapter_like")
    public Collection<chapter_like> chapter_likes() {
        return chapter_likeRepostory.findAll();
    }

    @GetMapping("/chapter_like/{id}")
    public ResponseEntity<?> getchapter_like(@PathVariable Integer id) {
        Optional<chapter_like> chapter_like = chapter_likeRepostory.findById(id);
        return chapter_like.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/chapter_like/count/{chapter_id}")
    public Integer countchapter_likebychapter_id(@PathVariable Integer chapter_id) {
        List<Object> chapter_like = chapter_likeRepostory.findBychapter_id(chapter_id);
        System.out.println(chapter_like);
        return chapter_like.size();
    }

    @GetMapping("/chapter_like/user_id/{user_id}")
    public List<Object> getchapter_likebyuser_id(@PathVariable Integer user_id) {
        return chapter_likeRepostory.findByuser_id(user_id);
    }

    @PostMapping("/chapter_like")
    public chapter_like createchapter_like(@Validated @RequestBody chapter_like chapter_like) throws Exception {

        chapter_like result = (com.penana.backend.Model.chapter_like) chapter_likeRepostory
                .findByuser_idAndChapter_id(chapter_like.getUser_id(), chapter_like.getChapter_id());
        System.out.println(result);
        if (result != null) {
            result.setMark_deleted("F");
            chapter_likeRepostory.saveAndFlush(result);
            return result;
        } else {
            chapter_like.setMark_deleted("F");
            chapter_like resultCreate = chapter_likeRepostory.save(chapter_like);
            return resultCreate;
        }

    }

    @PostMapping("/chapter_like/setdelete")
    public chapter_like setdeletechapter_like(@Validated @RequestBody chapter_like chapter_like) throws Exception {

        chapter_like result = (com.penana.backend.Model.chapter_like) chapter_likeRepostory
                .findByuser_idAndChapter_id(chapter_like.getUser_id(), chapter_like.getChapter_id());
        System.out.println(result);
        if (result != null) {
            result.setMark_deleted("T");
            chapter_likeRepostory.saveAndFlush(result);
            return result;
        } else {
            chapter_like.setMark_deleted("T");
            chapter_like resultCreate = chapter_likeRepostory.save(chapter_like);
            return resultCreate;
        }

    }

    @PutMapping("/chapter_like/{id}")
    public ResponseEntity<chapter_like> updatechapter_like(@PathVariable Integer id,
            @Validated @RequestBody chapter_like chapter_like) {

        chapter_like.setId(id);

        chapter_like result = chapter_likeRepostory.saveAndFlush(chapter_like);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/chapter_like/{id}")
    public ResponseEntity<?> deletechapter_like(@PathVariable Integer id) {

        chapter_likeRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
