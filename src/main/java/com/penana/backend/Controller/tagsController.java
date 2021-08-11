package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.tags;

import com.penana.backend.Dao.tagsRepostory;

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
public class tagsController {
    @Autowired
    private tagsRepostory tagsRepostory;

    @GetMapping("/tags")
    public Collection<tags> tagss() {
        return tagsRepostory.findAll();
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<?> gettags(@PathVariable Integer id) {
        Optional<tags> tags = tagsRepostory.findById(id);
        return tags.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/tags")
    public ResponseEntity<tags> createtags(@Validated @RequestBody tags tags) throws Exception {
        tags result = tagsRepostory.save(tags);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<tags> updatetags(@PathVariable Integer id, @Validated @RequestBody tags tags) {

        tags.setId(id);

        tags result = tagsRepostory.saveAndFlush(tags);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/tags/{id}")
    public ResponseEntity<?> deletetags(@PathVariable Integer id) {

        tagsRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
