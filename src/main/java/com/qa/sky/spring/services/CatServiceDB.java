package com.qa.sky.spring.services;

import com.qa.sky.spring.dto.CatDTO;
import com.qa.sky.spring.dto.CatWithOwnerDTO;
import com.qa.sky.spring.entities.Cat;
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
    public ResponseEntity<CatWithOwnerDTO> addCat(CatWithOwnerDTO newCat) {
        Cat toSave = new Cat(newCat);
        Cat created = this.repo.save(toSave);
        return new ResponseEntity<>(new CatWithOwnerDTO(created), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getCat(int id) {
        Optional<Cat> optCat = this.repo.findById(id);


        if (optCat.isPresent())
            return ResponseEntity.ok(new CatWithOwnerDTO(optCat.get()));
        else
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);

    }

    @Override
    public List<CatWithOwnerDTO> getAll() {
        return this.repo.findAll().stream().map(CatWithOwnerDTO::new).toList();
    }

    @Override
    public ResponseEntity<?> getCatByName(String name) {
        Optional<Cat> optCat = this.repo.findByNameIgnoreCase(name);

        if (optCat.isPresent())
            return ResponseEntity.ok(new CatWithOwnerDTO(optCat.get()));
        else
            return new ResponseEntity<>("No cat found with name: " + name, HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<?> updateCat(int id, String name, Integer age, String furColour) {
        Optional<Cat> optCat = this.repo.findById(id);

        Cat toUpdate = null;
        if (optCat.isPresent()) {
            toUpdate = optCat.get();
        } else {
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
        }

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (furColour != null) toUpdate.setFurColour(furColour);

        Cat updated = this.repo.save(toUpdate);

        return ResponseEntity.ok(new CatDTO(updated));

    }

    @Override
    public ResponseEntity<?> remove(int id) {
        Optional<Cat> optCat = this.repo.findById(id);

        if (optCat.isPresent()) {
            this.repo.deleteById(id);
            return ResponseEntity.ok(new CatDTO(optCat.get()));
        } else {
            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
