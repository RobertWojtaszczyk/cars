package pl.rw.demo.cars.service;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import pl.rw.demo.cars.model.Car;
import pl.rw.demo.cars.model.CarEntity;
import pl.rw.demo.cars.model.NewCar;
import pl.rw.demo.cars.repository.CarsRepository;

@Service
public class CarsService {

    private final CarsRepository carsRepository;

    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<Car> getCars() {
        return List.ofAll(this.carsRepository.findAll())
                .map(CarEntity::toCar);
    }

    public Car addCar(final NewCar newCar) {
        return carsRepository.save(new CarEntity(
                newCar.manufacturer,
                newCar.color,
                newCar.engineType)).toCar();
    }
}
