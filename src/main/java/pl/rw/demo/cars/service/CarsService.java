package pl.rw.demo.cars.service;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.rw.demo.cars.model.Car;
import pl.rw.demo.cars.model.CarEntity;
import pl.rw.demo.cars.model.NewCar;
import pl.rw.demo.cars.repository.CarsRepository;

import java.util.Optional;

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

    @Transactional
    public Optional<Car> changeColor(final Long id, final String color) {
        final Optional<CarEntity> car = this.carsRepository.findById(id);
        return car.map(carEntity -> {carEntity.setColor(color); return carEntity.toCar();});
    }
}
