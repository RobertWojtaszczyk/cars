package pl.rw.demo.cars.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public CarEntity(String manufacturer, String color, String engineType) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.engineType = engineType;
    }

    protected CarEntity() {
    }
}
