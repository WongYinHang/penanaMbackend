package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.user_follow;

import com.penana.backend.Dao.user_followRepostory;

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
public class user_followController {
    @Autowired
    private user_followRepostory user_followRepostory;

    @GetMapping("/user_follow")
    public Collection<user_follow> user_follows() {
        return user_followRepostory.findAll();
    }

    @GetMapping("/user_follow/{id}")
    public ResponseEntity<?> getuser_follow(@PathVariable Integer id) {
        Optional<user_follow> user_follow = user_followRepostory.findById(id);
        return user_follow.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user_follow")
    public user_follow createuser_follow(@Validated @RequestBody user_follow user_follow) throws Exception {

        user_follow result = user_followRepostory.findByUser_idAndFollowed_id(user_follow.getUser_id(),
                user_follow.getFollowed_id());
        System.out.println(result);
        if (result != null) {
            result.setMark_deleted("F");
            user_followRepostory.saveAndFlush(result);
            return result;
        } else {
            user_follow.setMark_deleted("F");
            user_follow resultCreate = user_followRepostory.save(user_follow);
            return resultCreate;
        }

    }

    @PostMapping("/user_follow/setdelete")
    public user_follow setdeleteuser_follow(@Validated @RequestBody user_follow user_follow) throws Exception {

        user_follow result = user_followRepostory.findByUser_idAndFollowed_id(user_follow.getUser_id(),
                user_follow.getFollowed_id());
        System.out.println(result);
        if (result != null) {
            result.setMark_deleted("T");
            user_followRepostory.saveAndFlush(result);
            return result;
        } else {
            user_follow.setMark_deleted("T");
            user_follow resultCreate = user_followRepostory.save(user_follow);
            return resultCreate;
        }

    }

    @PutMapping("/user_follow/{id}")
    public ResponseEntity<user_follow> updateuser_follow(@PathVariable Integer id,
            @Validated @RequestBody user_follow user_follow) {

        user_follow.setId(id);

        user_follow result = user_followRepostory.saveAndFlush(user_follow);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/user_follow/{id}")
    public ResponseEntity<?> deleteuser_follow(@PathVariable Integer id) {

        user_followRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
