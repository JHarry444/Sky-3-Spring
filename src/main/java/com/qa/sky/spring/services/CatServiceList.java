package com.qa.sky.spring.services;

import com.qa.sky.spring.entities.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class CatServiceList implements CatService{

    private List<Cat> cats = new ArrayList<>(); // stand-in for the db

    public CatServiceList() {
        this.cats.add(new Cat("Garfield", 40, "Ginger"));
        this.cats.add(new Cat("Jess", 35, "Black And White"));
    }

    @Override
    public ResponseEntity<?> getCat(int id) {
        try {
            return ResponseEntity.ok(this.cats.get(id));
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Cat> getAll() {
         return this.cats;
    }

    @Override
    public ResponseEntity<Cat> addCat(Cat newCat) {
        this.cats.add(newCat);
        Cat created = this.cats.get(this.cats.size() - 1);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @Override
    public Cat updateCat(int id, String name, Integer age, String furColour) {
        Cat toUpdate = this.cats.get(id);

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (furColour != null) toUpdate.setFurColour(furColour);

        return toUpdate;
    }

    @Override
    public Cat remove(int id) {
        return this.cats.remove(id);
    }
}