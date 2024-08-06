package com.qa.sky.spring.rest;


import com.qa.sky.spring.entities.Cat;
import com.qa.sky.spring.services.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatController {


    private CatService service;

    public CatController(CatService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!"; // returned values are stored in response body
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCat(@PathVariable int id) {
        return this.service.getCat(id);
    }

    @GetMapping("/getAll")
    public List<Cat> getAll() {
        return this.service.getAll();
    }


    @PostMapping("/create")
    public ResponseEntity<Cat> addCat(@RequestBody Cat newCat) {
        return this.service.addCat(newCat);
    }

    @PatchMapping("/update/{id}")
    public Cat updateCat(@PathVariable int id,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) Integer age,
                         @RequestParam(required = false) String colour) {
        return this.service.updateCat(id, name, age, colour);
    }


    @DeleteMapping("/remove/{id}")
    public Cat remove(@PathVariable int id) {
        return this.service.remove(id);
    }
}
