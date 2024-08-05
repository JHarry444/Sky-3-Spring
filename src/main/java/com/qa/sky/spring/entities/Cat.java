package com.qa.sky.spring.entities;

import jakarta.validation.constraints.Min;

public class Cat {


    private String name;
    @Min(0)
    private int age;
    private String colour;

    public Cat() {
        super();
    }

    public Cat(String name, int age, String colour) {
        super();
        this.name = name;
        this.age = age;
        this.colour = colour;
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

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", colour='" + colour + '\'' +
                '}';
    }
}
