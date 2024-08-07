package com.qa.sky.spring.services;

import com.qa.sky.spring.dto.CatDTO;
import com.qa.sky.spring.dto.CatWithOwnerDTO;
import com.qa.sky.spring.entities.Cat;
import com.qa.sky.spring.exceptions.CatNotFoundException;
import com.qa.sky.spring.repos.CatRepo;
import com.qa.sky.spring.repos.PersonRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary // tells spring to use this one
public class CatServiceDB implements CatService {


    private CatRepo repo;

    public CatServiceDB(CatRepo repo) {
        this.repo = repo;
    }

    @Override
    public CatWithOwnerDTO addCat(CatWithOwnerDTO newCat) {
        Cat toSave = new Cat(newCat);
        Cat created = this.repo.save(toSave);
        return new CatWithOwnerDTO(created);
    }

    @Override
    public CatWithOwnerDTO getCat(int id) {
        Cat found = this.repo.findById(id).orElseThrow(CatNotFoundException::new);
        return new CatWithOwnerDTO(found);
    }

    @Override
    public List<CatWithOwnerDTO> getAll() {
        return this.repo.findAll().stream().map(CatWithOwnerDTO::new).toList();
    }

    @Override
    public CatWithOwnerDTO getCatByName(String name) {
        Cat found = this.repo.findByNameIgnoreCase(name).orElseThrow(CatNotFoundException::new);
        return new CatWithOwnerDTO(found);
    }


    @Override
    public CatWithOwnerDTO updateCat(int id, String name, Integer age, String furColour) {
        Cat toUpdate = this.repo.findById(id).orElseThrow(CatNotFoundException::new);

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (furColour != null) toUpdate.setFurColour(furColour);

        Cat updated = this.repo.save(toUpdate);

        return new CatWithOwnerDTO(updated);
    }

    @Override
    public CatWithOwnerDTO remove(int id) {
        Cat found = this.repo.findById(id).orElseThrow(CatNotFoundException::new);
        this.repo.deleteById(id);
        return new CatWithOwnerDTO(found);
    }
}
