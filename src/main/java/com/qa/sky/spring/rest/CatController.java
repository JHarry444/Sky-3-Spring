package com.qa.sky.spring.rest;


import com.qa.sky.spring.entities.Cat;
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


    @GetMapping("/getAll")
    public List<Cat> getAll() {
        return this.cats;
    }


    @PostMapping("/create")
    public Cat addCat(@RequestBody Cat newCat) {
        this.cats.add(newCat);
        return this.cats.get(this.cats.size() - 1);
    }


    @DeleteMapping("/remove/{id}")
    public Cat remove(@PathVariable int id) {
        return this.cats.remove(id);
    }
}
