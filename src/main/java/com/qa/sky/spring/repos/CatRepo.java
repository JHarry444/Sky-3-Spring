package com.qa.sky.spring.repos;

import com.qa.sky.spring.entities.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Cat, Integer> {
}
