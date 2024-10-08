package com.qa.sky.spring.dto;

import com.qa.sky.spring.entities.Cat;
import com.qa.sky.spring.entities.Person;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

public class CatDTO {

    private Integer id;

    private String name;
    private int age;
    private String furColour;

    public CatDTO() {
    }

    public CatDTO(Integer id, String name, int age, String furColour) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.furColour = furColour;
    }

    public CatDTO(Cat cat) {
        this.id = cat.getId();
        this.name = cat.getName();
        this.age = cat.getAge();
        this.furColour = cat.getFurColour();
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

    public String getFurColour() {
        return furColour;
    }

    public void setFurColour(String furColour) {
        this.furColour = furColour;
    }
}
