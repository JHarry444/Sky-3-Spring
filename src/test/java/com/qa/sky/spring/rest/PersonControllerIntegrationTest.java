package com.qa.sky.spring.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.sky.spring.dto.CatDTO;
import com.qa.sky.spring.dto.PersonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

// loads the application context (runs the spring app, so we can test it)
// uses a random port to make the test more reliable
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // creates the mockmvc object
@Sql(scripts = {"classpath:test-schema.sql", "classpath:test-data.sql"},
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class PersonControllerIntegrationTest {

    @Autowired // requests the object from spring
    private MockMvc mvc; // sends the mock requests


    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        PersonDTO newPerson = new PersonDTO(null, "Aswene", 24, "Trainer", null);
        String newPersonAsJSON = this.mapper.writeValueAsString(newPerson);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/person/create")
                .content(newPersonAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        PersonDTO createdPerson = new PersonDTO(4, "Aswene", 24, "Trainer", null);
        String createdPersonAsJSON = this.mapper.writeValueAsString(createdPerson);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdPersonAsJSON);


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); // performs the request and checks the response

    }

    @Test
    void testGetById() throws Exception {
        RequestBuilder req = MockMvcRequestBuilders.get("/person/get/1");


        ResultMatcher checkStatus = MockMvcResultMatchers.status().isOk();
        List<CatDTO> cats = List.of(
                new CatDTO(1, "Tiddles", 12, "Black"),
                new CatDTO(2, "Garfield", 46, "Orange")
        );
        PersonDTO found = new PersonDTO(1, "Jordan H", 30, "Trainer", cats);
        String foundAsJSON = this.mapper.writeValueAsString(found);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(foundAsJSON);


        this.mvc.perform(req).andExpect(checkBody).andExpect(checkStatus);
    }

}
