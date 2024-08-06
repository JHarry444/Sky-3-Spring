package com.qa.sky.spring.services;

import com.qa.sky.spring.entities.Cat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CatServiceDB implements CatService{


    @Override
    public ResponseEntity<?> getCat(int id) {
        return null;
    }

    @Override
    public List<Cat> getAll() {
        return List.of();
    }

    @Override
    public ResponseEntity<Cat> addCat(Cat newCat) {
        return null;
    }

    @Override
    public Cat updateCat(int id, String name, Integer age, String colour) {
        return null;
    }

    @Override
    public Cat remove(int id) {
        return null;
    }
}
