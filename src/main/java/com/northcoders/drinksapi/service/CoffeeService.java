package com.northcoders.drinksapi.service;

import com.northcoders.drinksapi.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class CoffeeService {

    private final AtomicLong counter =  new AtomicLong();

    public Coffee someCall(String name) {

        return new Coffee(counter.incrementAndGet(), name);
    }
}
