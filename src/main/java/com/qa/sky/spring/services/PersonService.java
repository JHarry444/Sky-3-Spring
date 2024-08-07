package com.qa.sky.spring.services;

import com.qa.sky.spring.dto.PersonDTO;
import com.qa.sky.spring.entities.Person;
import com.qa.sky.spring.repos.PersonRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary // tells spring to use this one
public class PersonService  {


    private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }

    
    public ResponseEntity<Person> addPerson(PersonDTO newPersonDTO) {
        Person toSave = new Person(newPersonDTO);
        Person created = this.repo.save(toSave);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    
    public ResponseEntity<?> getPerson(int id) {
        Optional<Person> optPerson = this.repo.findById(id);


        if (optPerson.isPresent())
            return ResponseEntity.ok(new PersonDTO(optPerson.get()));
        else
            return new ResponseEntity<>("No person found with id: " + id, HttpStatus.NOT_FOUND);

    }

    
    public List<PersonDTO> getAll() {
        return this.repo.findAll().stream().map(PersonDTO::new).toList();
    }

    
    public ResponseEntity<?> updatePerson(int id, String name, Integer age, String job) {
        Optional<Person> optPerson = this.repo.findById(id);

        Person toUpdate = null;
        if (optPerson.isPresent()) {
            toUpdate = optPerson.get();
        } else {
            return new ResponseEntity<>("No person found with id: " + id, HttpStatus.NOT_FOUND);
        }

        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (job != null) toUpdate.setJob(job);

        Person updated = this.repo.save(toUpdate);

        return ResponseEntity.ok(new PersonDTO(updated));

    }

    
    public ResponseEntity<?> remove(int id) {
        Optional<Person> optPerson = this.repo.findById(id);

        if (optPerson.isPresent()) {
            this.repo.deleteById(id);
            return ResponseEntity.ok(new PersonDTO(optPerson.get()));
        } else {
            return new ResponseEntity<>("No person found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }
}
