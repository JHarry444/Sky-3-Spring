package com.qa.sky.spring.dto;

import com.qa.sky.spring.entities.Person;

import java.util.List;

public class PersonDTO {
    private Integer id;

    private String name;
    private int age;
    private String job;

    private List<CatDTO> cats;

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.age = person.getAge();
        this.job = person.getJob();

        if(person.getCats() != null) {
            this.cats = person.getCats().stream().map(CatDTO::new).toList();
        }

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<CatDTO> getCats() {
        return cats;
    }

    public void setCats(List<CatDTO> cats) {
        this.cats = cats;
    }
}
