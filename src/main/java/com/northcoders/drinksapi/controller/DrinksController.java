package com.northcoders.drinksapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinksController {

    @GetMapping("/")
    public String getWelcomeMessage() {
        return "Welcome to the Drinks API!";
    }

}
