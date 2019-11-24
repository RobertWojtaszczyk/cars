package pl.rw.demo.cars.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.rw.demo.cars.error.NoCarException;
import pl.rw.demo.cars.model.Car;
import pl.rw.demo.cars.model.NewCar;
import pl.rw.demo.cars.model.OilService;
import pl.rw.demo.cars.service.CarsService;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class CarsController {

    private final CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    // curl -d '{"manufacturer":"Toyota","color":"Silver","engineType":"Petrol"}' -H "Content-Type:application/json" http://localhost:8080/demo/cars
    // curl -d '{"manufacturer":"Ford","color":"Black","engineType":"Diesel"}' -H "Content-Type:application/json" http://localhost:8080/demo/cars
    // curl -d '{"manufacturer":"Opel","color":"Vectra","engineType":"Petrol"}' -H "Content-Type:application/json" http://localhost:8080/demo/cars
    // curl -X POST http://localhost:8080/demo/cars/1/color/Red
    // curl -d '{"mileage":89500,"comment":"Oil and oil filter"}' -H "Content-Type:application/json" http://localhost:8080/demo/cars/1/service

    @GetMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getCars() {
        return this.carsService.getCars().asJava();
    }

    @PostMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car addCar(@RequestBody NewCar car) {
        return this.carsService.addCar(car);
    }

    @PostMapping(path = "/cars/{id}/color/{color}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car setColor(@PathVariable("id") final Long id, @PathVariable("color") final String color) throws NoCarException {
        return this.carsService.changeColor(id, color)
                .getOrElseThrow(() -> new NoCarException(id));
                // .orElseThrow(() -> new NoCarException(id));
    }

    @PostMapping(path = "/cars/{id}/service", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int addOilService(@PathVariable("id") final Long id, @RequestBody OilService oilService) throws NoCarException {
        return this.carsService.addOilService(id, oilService)
                .getOrElseThrow(() -> new NoCarException(id));
                // .orElseThrow(() -> new NoCarException(id));
    }
}
