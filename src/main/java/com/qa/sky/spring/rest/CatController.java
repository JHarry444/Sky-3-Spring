package com.qa.sky.spring.rest;


import com.qa.sky.spring.entities.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatController {


    private List<Cat> cats = new ArrayList<>(); // stand-in for the db

    public CatController() {
        this.cats.add(new Cat("Garfield", 40, "Ginger"));
        this.cats.add(new Cat("Jess", 35, "Black And White"));
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!"; // returned values are stored in response body
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCat(@PathVariable int id) {
        try {
            return ResponseEntity.ok(this.cats.get(id));
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public List<Cat> getAll() {
        return this.cats;
    }


    @PostMapping("/create")
    public ResponseEntity<Cat> addCat(@RequestBody Cat newCat) {
        this.cats.add(newCat);
        Cat created = this.cats.get(this.cats.size() - 1);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public Cat updateCat(@PathVariable int id,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) Integer age,
                         @RequestParam(required = false) String colour) {
        Cat toUpdate = this.cats.get(id);

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (colour != null) toUpdate.setColour(colour);

        return toUpdate;
    }


    @DeleteMapping("/remove/{id}")
    public Cat remove(@PathVariable int id) {
        return this.cats.remove(id);
    }
}
