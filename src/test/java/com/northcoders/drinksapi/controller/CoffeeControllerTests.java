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
public class CoffeeControllerTests {

    //This @Autowired is part of Spring
    //It enables objects(beans) to be injected at runtime by Spring Dependency Injection mechanism
    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void coffeeLover() throws Exception {
        //Arrange, Act and Assert chained within the following statements

        String expectedContent = "I love coffee!";

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffeelover"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    @DisplayName("When /coffee endpoint requested with no coffee name param provided in request, " +
            "expecting JSON returned with default name:Latte  along with an auto generated id")
    public void testCoffeeDefault() throws Exception {

        //Arrange, Act and Assert chained within the following statements
        String expectedCoffeeName = CoffeeController.DEFAULT_COFFEE_NAME; // default

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                // TODO: How to check json param is a postive whole number?
                // Add some check onto it?
                //.andExpect(MockMvcResultMatchers.jsonPath("$.id")
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedCoffeeName));
    }

    @Test
    @DisplayName("When /coffee endpoint requested with coffee name param provided in request, " +
            "expecting JSON returned with name:Coffee name provided along with an auto generated id")
    public void testCoffeeWithNameParam() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String inputCoffeeName = "Expresso";
        String expectedCoffeeName = inputCoffeeName;

        this.mockMvcController.perform(
                                MockMvcRequestBuilders.get("/coffee")
                                .param("name", inputCoffeeName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedCoffeeName));

                // TODO: Add check to ensure we have an id and
                //  if possible check it is a positive whole number.
    }

}
