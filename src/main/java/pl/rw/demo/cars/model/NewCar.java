package pl.rw.demo.cars.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewCar {
    public final String manufacturer;
    public final String color;
    public final String engineType;

    @JsonCreator
    public NewCar(
            @JsonProperty("manufacturer")
            String manufacturer,
            @JsonProperty("color")
            String color,
            @JsonProperty("engineType")
            String engineType) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.engineType = engineType;
    }
}
