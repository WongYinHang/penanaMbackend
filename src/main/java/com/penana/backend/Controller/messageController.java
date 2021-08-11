package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.message;

import com.penana.backend.Dao.messageRepostory;

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
public class messageController {
    @Autowired
    private messageRepostory messageRepostory;

    @GetMapping("/message")
    public Collection<message> messages() {
        return messageRepostory.findAll();
    }

    @GetMapping("/message/{id}")
    public ResponseEntity<?> getmessage(@PathVariable Integer id) {
        Optional<message> message = messageRepostory.findById(id);
        return message.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/message")
    public ResponseEntity<message> createmessage(@Validated @RequestBody message message) throws Exception {
        message result = messageRepostory.save(message);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/message/{id}")
    public ResponseEntity<message> updatemessage(@PathVariable Integer id, @Validated @RequestBody message message) {

        message.setId(id);

        message result = messageRepostory.saveAndFlush(message);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/message/{id}")
    public ResponseEntity<?> deletemessage(@PathVariable Integer id) {

        messageRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
