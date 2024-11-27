package com.northcoders.drinksapi.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class HealthControllerTests {

    @Autowired
    private MockMvc mockMvcController;


    @Test
    @DisplayName("When /health endpoint requested expecting JSON returned with status message")
    public void testHealthWithValidEndpoint() throws Exception {
        String expectedContent = HealthController.HEALTHY_API_MESSAGE;
        this.mockMvcController
                .perform(MockMvcRequestBuilders.get("/health"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    @DisplayName("When /invalid endpoint requested expecting JSON returned with status message 404 Not Found")
    public void testHealthWithInvalidEndpoint() throws Exception {
        this.mockMvcController
                .perform(MockMvcRequestBuilders.get("/invalidHealth"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());  // 404 status code
               // .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    /*
        Note  endpoint /actuator/health depends on dependency spring-boot-starter-actuator and various management.endpoint settings in application.properties
     */
    @Test
    @DisplayName("When /actuator/health endpoint requested expecting JSON returned with key=status, value= UP")
    public void testActuatorHealth() throws Exception {

        String expectedContent = "UP";
        this.mockMvcController
                .perform(MockMvcRequestBuilders.get("/actuator/health"))
                .andExpect(MockMvcResultMatchers.status().isOk())   // 200 status code
                // status:up
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(expectedContent));
    }

}
