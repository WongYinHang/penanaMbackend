package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.notification;

import com.penana.backend.Dao.notificationRepostory;

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
public class notificationController {
    @Autowired
    private notificationRepostory notificationRepostory;

    @GetMapping("/notification")
    public Collection<notification> notifications() {
        return notificationRepostory.findAll();
    }

    @GetMapping("/notification/{id}")
    public ResponseEntity<?> getnotification(@PathVariable Integer id) {
        Optional<notification> notification = notificationRepostory.findById(id);
        return notification.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/notification")
    public ResponseEntity<notification> createnotification(@Validated @RequestBody notification notification)
            throws Exception {
        notification result = notificationRepostory.save(notification);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/notification/{id}")
    public ResponseEntity<notification> updatenotification(@PathVariable Integer id,
            @Validated @RequestBody notification notification) {

        notification.setId(id);

        notification result = notificationRepostory.saveAndFlush(notification);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/notification/{id}")
    public ResponseEntity<?> deletenotification(@PathVariable Integer id) {

        notificationRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
