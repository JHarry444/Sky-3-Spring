package com.qa.sky.spring.services;

import com.qa.sky.spring.entities.Cat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatService {


    ResponseEntity<?> getCat(int id);

    List<Cat> getAll();


    ResponseEntity<?> getCatByName(String name);

    ResponseEntity<Cat> addCat(Cat newCat);

    ResponseEntity<?> updateCat(int id,
                                String name,
                                Integer age,
                                String colour);


    ResponseEntity<?> remove(int id);
}
