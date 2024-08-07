package com.qa.sky.spring.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity // marks the class as a table
@Table(name = "cat") // lets you configure the created table
public class Cat {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;
    private int age;
    private String furColour;

    @ManyToOne
    private Person owner;

    public Cat(String name, int age, String furColour) {
        this.name = name;
        this.age = age;
        this.furColour = furColour;
    }

    // REQUIRED
    public Cat() {
        super();
    }


    // REQUIRED
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
