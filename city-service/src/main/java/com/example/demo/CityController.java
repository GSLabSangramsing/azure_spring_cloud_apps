package com.example.demo;

import reactor.core.publisher.Flux;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/cities")
    public Flux<List<City>> getAllCities() {
        return (Flux<List<City>>) cityRepository.findAll();
    }
}
