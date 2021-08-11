package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.user;

import com.penana.backend.Dao.userRepostory;

import org.springframework.beans.factory.annotation.Autowired;

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
public class userController {
    @Autowired
    private userRepostory userRepostory;

    @GetMapping("/user")
    public Collection<user> users() {
        return userRepostory.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getuser(@PathVariable Integer id) {
        System.out.println("Controller Searching user " + id);
        Optional<user> user = userRepostory.findById(id);

        user response = new user(user.get().getId(), user.get().getUsername(), user.get().getProfile_picture());

        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<?> getuserbyemail(@PathVariable String email) {
        System.out.println("Controller Searching user " + email);
        Optional<Object> user = userRepostory.findByEmail(email);
        if (user != null) {
            user response = new user(((com.penana.backend.Model.user) user.get()).getId(),
                    ((com.penana.backend.Model.user) user.get()).getUsername(),
                    ((com.penana.backend.Model.user) user.get()).getProfile_picture(),
                    ((com.penana.backend.Model.user) user.get()).getCoin_balance());
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.ok().body("user not found");
        }

    }

    @PostMapping("/user")
    public ResponseEntity<user> createuser(@Validated @RequestBody user user) throws Exception {
        user result = userRepostory.save(user);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<user> updateuser(@PathVariable Integer id, @Validated @RequestBody user user) {
        Optional<user> Originaluser = userRepostory.findById(id);

        if (user.getUsername() != null) {
            Originaluser.get().setUsername(user.getUsername());
        }

        user result = userRepostory.save(Originaluser.get());
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteuser(@PathVariable Integer id) {

        userRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
