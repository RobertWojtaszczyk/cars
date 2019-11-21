package pl.rw.demo.cars.repository;

import org.springframework.data.repository.CrudRepository;
import pl.rw.demo.cars.model.CarEntity;

public interface CarsRepository extends CrudRepository<CarEntity, Long> {
}
