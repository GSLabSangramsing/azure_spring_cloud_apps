package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;

@RestController
@RequestMapping(path="/weather")
public class WeatherController {

    private final WeatherRepository weatherRepository;

    public WeatherController(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/city")
    public @ResponseBody Weather getWeatherForCity(@RequestParam("name") String cityName) {
		return weatherRepository.findById(cityName).map(weather -> {
            weather.setDescription("It's always sunny on Azure Spring Cloud");
            weather.setIcon("weather-sunny");
            return weather;
        }).get();
    }

    @GetMapping("/city/{icon}")
    public @ResponseBody Weather getWeatherByIcon(@PathVariable("icon") String icon) {
        return weatherRepository.findByIcon(icon).map(weather -> {
            weather.setDescription("It's always sunny on Azure Spring Cloud");
            return weather;
        }).get();
    }
}
