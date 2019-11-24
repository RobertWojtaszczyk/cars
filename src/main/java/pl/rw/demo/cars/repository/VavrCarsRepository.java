package pl.rw.demo.cars.repository;

import io.vavr.control.Option;
import org.springframework.data.repository.Repository;
import pl.rw.demo.cars.model.CarEntity;

public interface VavrCarsRepository extends Repository<CarEntity, Long> {

    Iterable<CarEntity> findAll();
    CarEntity save(CarEntity person);
    Option<CarEntity> findById(Long id);
}
