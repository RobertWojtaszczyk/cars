package pl.rw.demo.cars.service;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.rw.demo.cars.model.*;
import pl.rw.demo.cars.repository.CarsRepository;
import pl.rw.demo.cars.repository.OilServiceRepository;

import java.util.Optional;

@Service
public class CarsService {

    private final CarsRepository carsRepository;
    private final OilServiceRepository oilServiceRepository;

    public CarsService(CarsRepository carsRepository, OilServiceRepository oilServiceRepository) {
        this.carsRepository = carsRepository;
        this.oilServiceRepository = oilServiceRepository;
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
    public Optional<Car> changeColor(final Long carId, final String color) {
        final Optional<CarEntity> car = this.carsRepository.findById(carId);
        return car.map(carEntity -> {carEntity.setColor(color); return carEntity.toCar();});
    }

    @Transactional
    public Optional<Integer> addOilService(final Long carId, final OilService oilService) {
        final Optional<CarEntity> car = this.carsRepository.findById(carId);
        return car.map(carEntity -> {this.oilServiceRepository.save(new OilServiceEntity(
                oilService.mileage,
                oilService.comment,
                carEntity));
        return List.ofAll(carEntity.getOilServices()).size();
        });
    }
}
