package pl.rw.demo.cars.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class OilServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long mileage;

    private String comment;

    @ManyToOne
    private CarEntity car;
}
