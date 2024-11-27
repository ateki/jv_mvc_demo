package com.northcoders.drinksapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    @GetMapping("/coffeelover")
    public String coffeeLover (){

        return "I love coffee!";
    }
}
