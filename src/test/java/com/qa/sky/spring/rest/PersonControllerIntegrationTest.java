package com.qa.sky.spring.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.sky.spring.dto.PersonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// loads the application context (runs the spring app so we can test it)
// uses a random port to make the test more reliable
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // creates the mockmvc object
public class PersonControllerIntegrationTest {

    @Autowired // requests the object from spring
    private MockMvc mvc; // sends the mock requests


    @Autowired
    private ObjectMapper mapper;

    @Test
    void testCreate() throws Exception {
        PersonDTO newPerson = new PersonDTO(null, "Jordan", 30, "Trainer", null);
        String newPersonAsJSON = this.mapper.writeValueAsString(newPerson);
        RequestBuilder req = MockMvcRequestBuilders
                .post("/person/create")
                .content(newPersonAsJSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = MockMvcResultMatchers.status().isCreated();
        PersonDTO createdPerson = new PersonDTO(1, "Jordan", 30, "Trainer", null);
        String createdPersonAsJSON = this.mapper.writeValueAsString(createdPerson);
        ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdPersonAsJSON);


        this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); // performs the request and checks the response

    }
}
