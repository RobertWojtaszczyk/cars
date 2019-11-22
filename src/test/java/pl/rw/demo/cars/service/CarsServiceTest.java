package pl.rw.demo.cars.service;

import io.vavr.collection.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.rw.demo.cars.model.Car;
import pl.rw.demo.cars.model.NewCar;
import pl.rw.demo.cars.repository.CarsRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarsServiceTest {

    @Autowired
    private CarsRepository carsRepository;

    @AfterEach
    public void clearDatabase() {
        carsRepository.deleteAll();
    }

    @Test
    public void getEmptyList() {
        CarsService carsService = new CarsService(carsRepository);
        List<Car> cars = carsService.getCars();
        assertTrue(cars.isEmpty());
    }

    @Test
    public void addCar() {
        CarsService carsService = new CarsService(carsRepository);
        Car car = carsService.addCar(new NewCar("Toyota", "Silver", "Petrol"));
        assertNotNull(car);
        assertEquals("Toyota", car.manufacturer);
    }

    @Test
    public void addedCarHasNewId() {
        CarsService carsService = new CarsService(carsRepository);
        Car car1 = carsService.addCar(new NewCar("Toyota", "Silver", "Petrol"));
        Car car2 = carsService.addCar(new NewCar("Ford", "Silver", "Petrol"));
        assertNotEquals(car1.id, car2.id);
        assertEquals(2, carsService.getCars().size());
    }

}
