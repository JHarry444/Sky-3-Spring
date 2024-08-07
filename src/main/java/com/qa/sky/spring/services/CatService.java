package com.qa.sky.spring.services;

import com.qa.sky.spring.dto.CatDTO;
import com.qa.sky.spring.dto.CatWithOwnerDTO;
import com.qa.sky.spring.entities.Cat;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatService {


    CatWithOwnerDTO getCat(int id);

    List<CatWithOwnerDTO> getAll();


    CatWithOwnerDTO getCatByName(String name);

    CatWithOwnerDTO addCat(CatWithOwnerDTO newCat);

    CatWithOwnerDTO updateCat(int id,
                                String name,
                                Integer age,
                                String colour);


    CatWithOwnerDTO remove(int id);
}
