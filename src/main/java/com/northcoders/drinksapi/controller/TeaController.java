package com.northcoders.drinksapi.controller;

import com.northcoders.drinksapi.model.Tea;
import com.northcoders.drinksapi.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeaController {

    private static final String DEFAULT_TEA_NAME = "black";
    @Autowired
    TeaService teaService;

    @GetMapping("/tea")
    public Tea getTea(@RequestParam(name="name", defaultValue = DEFAULT_TEA_NAME) String paramName) {
        return teaService.makeTeaObject(paramName);
    }

}
