package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Coffee;
import com.northcoders.drinksapi.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeService coffeeService;


    protected static final String DEFAULT_COFFEE_NAME = "latte";

    @GetMapping("/coffeelover")
    public String coffeeLover (){

        return "I love coffee!";
    }


    @GetMapping("/coffee")
    public ResponseEntity<Coffee> getCoffee (@RequestParam(name="name", defaultValue=DEFAULT_COFFEE_NAME) String nameParam){

        // To give default value for request param
        // Method 1:
        //      public String getCoffee (@RequestParam("name") Optional<String> nameParam){
        //      String coffeeName = nameParam.orElse(DEFAULT_COFFEE_NAME);
        // Method 2:  use defaultValue arg as part of @RequestParam

        // NOTE: Returns ResponseEntity<Coffee> and not just Coffee.
        // Includes whole HTTP response: status codes, headers, body status.  See TeaController.getTea which just returns the Tea object.
        return new ResponseEntity<>(coffeeService.makeCoffeeObject(nameParam), HttpStatus.OK);

    }
}
