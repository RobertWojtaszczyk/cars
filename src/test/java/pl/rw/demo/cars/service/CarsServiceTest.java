package pl.rw.demo.cars.service;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;
import pl.rw.demo.cars.model.CarDto;
import pl.rw.demo.cars.model.NewCar;

import static org.junit.jupiter.api.Assertions.*;

class CarsServiceTest {

    @Test
    public void getEmptyList() {
        CarsService carsService = new CarsService();
        List<CarDto> cars = carsService.getCars();
        assertTrue(cars.isEmpty());
    }

    @Test
    public void addCar() {
        CarsService carsService = new CarsService();
        CarDto car = carsService.addCar(new NewCar("Toyota", "Silver", "Petrol"));
        assertNotNull(car);
        assertEquals("Toyota", car.manufacturer);
    }

    @Test
    public void addedCarHasNewId() {
        CarsService carsService = new CarsService();
        CarDto car1 = carsService.addCar(new NewCar("Toyota", "Silver", "Petrol"));
        CarDto car2 = carsService.addCar(new NewCar("Ford", "Silver", "Petrol"));
        assertNotEquals(car1.id, car2.id);
        assertEquals(2, carsService.getCars().size());
    }

}
