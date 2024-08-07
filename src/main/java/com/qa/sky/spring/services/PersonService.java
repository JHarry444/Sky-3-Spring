package com.qa.sky.spring.services;

import com.qa.sky.spring.dto.PersonDTO;
import com.qa.sky.spring.entities.Person;
import com.qa.sky.spring.exceptions.PersonNotFoundException;
import com.qa.sky.spring.repos.PersonRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary // tells spring to use this one
public class PersonService {


    private PersonRepo repo;

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }


    public PersonDTO addPerson(PersonDTO newPersonDTO) {
        Person toSave = new Person(newPersonDTO);
        Person created = this.repo.save(toSave);
        return new PersonDTO(created);
    }


    public PersonDTO getPerson(int id) {
        Person found = this.repo.findById(id).orElseThrow(PersonNotFoundException::new);

        return new PersonDTO(found);

    }


    public List<PersonDTO> getAll() {
        return this.repo.findAll().stream().map(PersonDTO::new).toList();
    }


    public PersonDTO updatePerson(int id, String name, Integer age, String job) {
        Person toUpdate = this.repo.findById(id).orElseThrow(PersonNotFoundException::new);


        if (name != null) toUpdate.setName(name);
        if (age != null) toUpdate.setAge(age);
        if (job != null) toUpdate.setJob(job);

        Person updated = this.repo.save(toUpdate);

        return new PersonDTO(updated);

    }


    public PersonDTO remove(int id) {
        Person found = this.repo.findById(id).orElseThrow(PersonNotFoundException::new);
        this.repo.deleteById(id);
        return new PersonDTO(found);
    }

}
