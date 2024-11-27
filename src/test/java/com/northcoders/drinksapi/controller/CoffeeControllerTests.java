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
    @DisplayName("When /coffee endpoint requested with coffee name param provided in request, expecting JSON returned with name:Latte  along with id:<hard coded to 1 for now>")
    public void testCoffeeDefault() throws Exception {

        //Arrange, Act and Assert chained within the following statements
        Integer expectedId = 10;
        String expectedCoffeeName = CoffeeController.DEFAULT_COFFEE_NAME; // default

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedCoffeeName));
    }

    @Test
    @DisplayName("When /coffee endpoint requested with coffee name param provided in request, expecting JSON returned with name:Coffee name provided along with id:<hard coded to 1 for now>")
    public void testCoffeeWithNameParam() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String inputCoffeeName = "Expresso";
        String expectedCoffeeName = inputCoffeeName; // default

        this.mockMvcController.perform(
                                MockMvcRequestBuilders.get("/coffee")
                                .param("name", inputCoffeeName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedCoffeeName));
    }

}
