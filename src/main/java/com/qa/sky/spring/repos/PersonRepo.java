package com.qa.sky.spring.repos;

import com.qa.sky.spring.entities.Cat;
import com.qa.sky.spring.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {


}
