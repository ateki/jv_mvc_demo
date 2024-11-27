package com.northcoders.drinksapi.service;

import com.northcoders.drinksapi.model.Tea;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TeaService {

    private final AtomicLong counter =  new AtomicLong();

    public Tea makeTeaObject(String name) {
        return new Tea(counter.incrementAndGet(), name);
    }
}
