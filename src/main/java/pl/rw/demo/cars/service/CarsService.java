package pl.rw.demo.cars.service;

import io.vavr.collection.List;
import pl.rw.demo.cars.model.CarDto;
import pl.rw.demo.cars.model.NewCar;

public class CarsService {

    private List<CarDto> cars = List.empty();

    public List<CarDto> getCars() {
        return this.cars;
    }

    public CarDto addCar(final NewCar newCar) {
        CarDto car = new CarDto(cars.size(), newCar.manufacturer, newCar.color, newCar.engineType);
        cars = cars.prepend(car);
        return car;
    }
}
