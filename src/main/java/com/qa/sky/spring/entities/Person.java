package com.qa.sky.spring.entities;

import com.qa.sky.spring.dto.PersonDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int age;
    private String job;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Cat> cats;

    public Person() {
    }

    public Person(PersonDTO dto) {
        this.name = dto.getName();
        this.job = dto.getJob();
        this.age = dto.getAge();
    }


    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person(Integer id, String name, int age, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
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

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
