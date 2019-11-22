package pl.rw.demo.cars.repository;

import org.springframework.data.repository.CrudRepository;
import pl.rw.demo.cars.model.OilServiceEntity;

public interface OilServiceRepository extends CrudRepository<OilServiceEntity, Long> {
}
