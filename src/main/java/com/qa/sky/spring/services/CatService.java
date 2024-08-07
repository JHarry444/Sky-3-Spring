package com.qa.sky.spring.services;

import com.qa.sky.spring.dto.CatDTO;
import com.qa.sky.spring.dto.CatWithOwnerDTO;
import com.qa.sky.spring.entities.Cat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatService {


    ResponseEntity<?> getCat(int id);

    List<CatWithOwnerDTO> getAll();


    ResponseEntity<?> getCatByName(String name);

    ResponseEntity<CatWithOwnerDTO> addCat(CatWithOwnerDTO newCat);

    ResponseEntity<?> updateCat(int id,
                                String name,
                                Integer age,
                                String colour);


    ResponseEntity<?> remove(int id);
}
