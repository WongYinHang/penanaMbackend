package com.penana.backend.Controller;

import java.util.Collection;
import java.util.Optional;

import com.penana.backend.Model.acitvity;
import com.penana.backend.Controller.acitvityController;
import com.penana.backend.Dao.acitvityRepostory;

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
public class acitvityController {
    @Autowired
    private acitvityRepostory acitvityRepostory;

    @GetMapping("/acitvity")
    public Collection<acitvity> acitvitys() {
        return acitvityRepostory.findAll();
    }

    @GetMapping("/acitvity/{id}")
    public ResponseEntity<?> getacitvity(@PathVariable Integer id) {
        Optional<acitvity> acitvity = acitvityRepostory.findById(id);
        return acitvity.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/acitvity")
    public ResponseEntity<acitvity> createacitvity(@Validated @RequestBody acitvity acitvity) throws Exception {
        acitvity result = acitvityRepostory.save(acitvity);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/acitvity/{id}")
    public ResponseEntity<acitvity> updateacitvity(@PathVariable Integer id,
            @Validated @RequestBody acitvity acitvity) {

        acitvity.setId(id);

        acitvity result = acitvityRepostory.saveAndFlush(acitvity);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/acitvity/{id}")
    public ResponseEntity<?> deleteacitvity(@PathVariable Integer id) {

        acitvityRepostory.deleteById(id);
        return ResponseEntity.ok().build();
    }
}