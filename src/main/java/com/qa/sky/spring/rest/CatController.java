package com.qa.sky.spring.rest;


import com.qa.sky.spring.dto.CatWithOwnerDTO;
import com.qa.sky.spring.services.CatService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
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
    public CatWithOwnerDTO getCat(@PathVariable int id) {
        return this.service.getCat(id);
    }

    @GetMapping("/get/name/{name}")
    public CatWithOwnerDTO getCatByName(@PathVariable String name) {
        return this.service.getCatByName(name);
    }

    @GetMapping("/getAll")
    public List<CatWithOwnerDTO> getAll() {
        return this.service.getAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public CatWithOwnerDTO addCat(@RequestBody CatWithOwnerDTO newCat) {
        return this.service.addCat(newCat);
    }

    @PatchMapping("/update/{id}")
    public CatWithOwnerDTO updateCat(@PathVariable int id,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer age,
                                     @RequestParam(required = false) String furColour) {
        return this.service.updateCat(id, name, age, furColour);
    }


    @DeleteMapping("/remove/{id}")
    public CatWithOwnerDTO remove(@PathVariable int id) {
        return this.service.remove(id);
    }
}
