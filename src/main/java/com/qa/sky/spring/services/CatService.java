package com.qa.sky.spring.services;

import com.qa.sky.spring.entities.Cat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CatService {


    ResponseEntity<?> getCat(int id);

    List<Cat> getAll();


    ResponseEntity<Cat> addCat(Cat newCat);

    Cat updateCat(int id,
                  String name,
                  Integer age,
                  String colour);


    Cat remove(int id);
}
