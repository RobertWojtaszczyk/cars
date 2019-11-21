package pl.rw.demo.cars.service;

import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import pl.rw.demo.cars.model.CarDto;
import pl.rw.demo.cars.model.CarEntity;
import pl.rw.demo.cars.model.NewCar;
import pl.rw.demo.cars.repository.CarsRepository;

import java.util.function.Function;

@Service
public class CarsService {

    private final CarsRepository carsRepository;

    public CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<CarDto> getCars() {
        return List.ofAll(this.carsRepository.findAll())
                .map(getCarEntityCarDtoFunction()
                );
    }

    private Function<CarEntity, CarDto> getCarEntityCarDtoFunction() {
        return carEntity -> new CarDto(
                carEntity.getId(),
                carEntity.getManufacturer(),
                carEntity.getColor(),
                carEntity.getEngineType());
    }

    public CarDto addCar(final NewCar newCar) {
        CarEntity carEntity = carsRepository.save(new CarEntity(
                newCar.manufacturer,
                newCar.color,
                newCar.engineType));
        return getCarEntityCarDtoFunction().apply(carEntity);
    }
}
