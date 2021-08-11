package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.user_profile;

import com.penana.backend.Dao.user_profileRepostory;

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
public class user_profileController {
    @Autowired
    private user_profileRepostory user_profileRepostory;

    @GetMapping("/user_profile")
    public Collection<user_profile> user_profiles() {
        return user_profileRepostory.findAll();
    }

    @GetMapping("/user_profile/{id}")
    public ResponseEntity<?> getuser_profile(@PathVariable Integer id) {
        Optional<user_profile> user_profile = user_profileRepostory.findById(id);
        return user_profile.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user_profile")
    public ResponseEntity<user_profile> createuser_profile(@Validated @RequestBody user_profile user_profile)
            throws Exception {
        user_profile result = user_profileRepostory.save(user_profile);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/user_profile/{id}")
    public ResponseEntity<user_profile> updateuser_profile(@PathVariable Integer id,
            @Validated @RequestBody user_profile user_profile) {

        user_profile.setUser_id(id);

        user_profile result = user_profileRepostory.saveAndFlush(user_profile);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/user_profile/{id}")
    public ResponseEntity<?> deleteuser_profile(@PathVariable Integer id) {

        user_profileRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
