package com.northcoders.drinksapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    protected final static String HEALTHY_API_MESSAGE = "The Drinks API is running and available.";

    // TODO: This returns nothing if server is not up and running: could not send request
    @GetMapping("/health")
    public String getHealth() {
        return HEALTHY_API_MESSAGE;
    }

}
