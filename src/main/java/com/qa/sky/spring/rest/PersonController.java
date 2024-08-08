package com.qa.sky.spring.rest;


import com.qa.sky.spring.dto.PersonDTO;
import com.qa.sky.spring.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {


    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }


    @GetMapping("/get/{id}")
    public PersonDTO getPerson(@PathVariable int id) {
        return this.service.getPerson(id);
    }


    @GetMapping("/getAll")
    public List<PersonDTO> getAll() {
        return this.service.getAll();
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO addPerson(@RequestBody PersonDTO newPerson) {
        return this.service.addPerson(newPerson);
    }

    @PatchMapping("/update/{id}")
    public PersonDTO updatePerson(@PathVariable int id,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String furColour) {
        return this.service.updatePerson(id, name, age, furColour);
    }


    @DeleteMapping("/remove/{id}")
    public PersonDTO remove(@PathVariable int id) {
        return this.service.remove(id);
    }
}
