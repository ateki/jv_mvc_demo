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
public class TeaControllerTests {

    //This @Autowired is part of Spring
    //It enables objects(beans) to be injected at runtime by Spring Dependency Injection mechanism
    @Autowired
    private MockMvc mockMvcController;

    @Test
    @DisplayName("When /tea endpoint requested with no tea name param provided in request, " +
            "expecting JSON returned with default name:black  along with an auto generated id")
    public void testTeaDefault() throws Exception {

        String expectedTeaName = TeaController.DEFAULT_TEA_NAME; // default
        this.mockMvcController
                .perform(MockMvcRequestBuilders.get("/tea"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedTeaName));
                // TODO: Add id check
    }

    @Test
    @DisplayName("When /tea endpoint requested with tea name param provided in request, " +
            "expecting JSON returned with default name:Tea name provided along with an auto generated id")
    public void testTeaWithNameParam() throws Exception {

        String inputTeaName = "Peppermint";
        String expectedTeaName = inputTeaName;

        this.mockMvcController
                .perform(
                        MockMvcRequestBuilders.get("/tea")
                                .param("name", inputTeaName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedTeaName));

                // TODO: Add check to ensure we have an id and
                //  if possible check it is a positive whole number.
    }
}
