package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Coffee;
import com.northcoders.drinksapi.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeService coffeeService;


    private static final String DEFAULT_COFFEE_NAME = "latte";

    @GetMapping("/coffeelover")
    public String coffeeLover (){

        return "I love coffee!";
    }



    // TODO: Simon used ResponseEntity<Obj>
    // TODO: Try this as well as trying to return just Coffee
    @GetMapping("/coffee")
    public ResponseEntity<Coffee> getCoffee (@RequestParam(name="name", defaultValue="DEFAULT_COFFEE_NAME") String nameParam){

        // Method 1: to give default value
        // public String getCoffee (@RequestParam("name") Optional<String> nameParam){
        // String coffeeName = nameParam.orElse(DEFAULT_COFFEE_NAME);
        return new ResponseEntity<>(coffeeService.someCall(nameParam), HttpStatus.OK);

    }
}
