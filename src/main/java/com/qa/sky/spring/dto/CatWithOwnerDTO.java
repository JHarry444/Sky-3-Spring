package com.qa.sky.spring.dto;

import com.qa.sky.spring.entities.Cat;

public class CatWithOwnerDTO {

    private Integer id;

    private String name;
    private int age;
    private String furColour;

    private String owner;


    public CatWithOwnerDTO() {
    }

    public CatWithOwnerDTO(Cat cat) {
        this.id = cat.getId();
        this.name = cat.getName();
        this.age = cat.getAge();
        this.furColour = cat.getFurColour();

        if (cat.getOwner() != null) this.owner = cat.getOwner().getName();

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}