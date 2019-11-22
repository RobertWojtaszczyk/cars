package pl.rw.demo.cars.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String manufacturer;

    private String color;

    private String engineType;

    @OneToMany(mappedBy = "car")
    private Set<OilServiceEntity> oilServices;

    public CarEntity(String manufacturer, String color, String engineType) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.engineType = engineType;
    }

    protected CarEntity() {
    }

    public Car toCar() {
        return new Car(
                this.getId(),
                this.getManufacturer(),
                this.getColor(),
                this.getEngineType());
    }
}
