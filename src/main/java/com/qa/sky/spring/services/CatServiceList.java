//package com.qa.sky.spring.services;
//
//import com.qa.sky.spring.dto.CatWithOwnerDTO;
//import com.qa.sky.spring.entities.Cat;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//@Service
//public class CatServiceList implements CatService{
//
//    private List<Cat> cats = new ArrayList<>(); // stand-in for the db
//
//    public CatServiceList() {
//        this.cats.add(new Cat("Garfield", 40, "Ginger"));
//        this.cats.add(new Cat("Jess", 35, "Black And White"));
//    }
//
//    @Override
//    public ResponseEntity<?> getCat(int id) {
//        try {
//            return ResponseEntity.ok(this.cats.get(id));
//        } catch (IndexOutOfBoundsException e) {
//            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Override
//    public List<CatWithOwnerDTO> getAll() {
//         return this.cats.stream().map(CatWithOwnerDTO::new).toList();
//    }
//
//    @Override
//    public ResponseEntity<?> getCatByName(String name) {
//        return null;
//    }
//
//    @Override
//    public ResponseEntity<CatWithOwnerDTO> addCat(CatWithOwnerDTO newCat) {
//        this.cats.add(new Cat(newCat));
//        Cat created = this.cats.get(this.cats.size() - 1);
//        return new ResponseEntity<>(new CatWithOwnerDTO(created), HttpStatus.CREATED);
//    }
//
//    @Override
//    public ResponseEntity<?> updateCat(int id, String name, Integer age, String furColour) {
//        Cat toUpdate = this.cats.get(id);
//
//        if (name != null) toUpdate.setName(name);
//        if (age != null) toUpdate.setAge(age);
//        if (furColour != null) toUpdate.setFurColour(furColour);
//
//        return ResponseEntity.ok(new CatWithOwnerDTO(toUpdate));
//    }
//
//    @Override
//    public ResponseEntity<?> remove(int id) {
//        try {
//            return ResponseEntity.ok(new CatWithOwnerDTO(this.cats.remove(id)));
//        } catch (IndexOutOfBoundsException e) {
//            return new ResponseEntity<>("No cat found with id: " + id, HttpStatus.NOT_FOUND);
//        }
//    }
//}
