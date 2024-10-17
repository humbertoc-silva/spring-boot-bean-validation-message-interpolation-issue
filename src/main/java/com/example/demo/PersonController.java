package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(person);
    }

}
