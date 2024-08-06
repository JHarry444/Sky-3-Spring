package com.qa.sky.spring.repos;

import com.qa.sky.spring.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatRepo extends JpaRepository<Cat, Integer> {


    Optional<Cat> findByNameIgnoreCase(String name);
}
