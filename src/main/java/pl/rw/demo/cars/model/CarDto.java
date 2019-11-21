package pl.rw.demo.cars.model;

public class CarDto {
    public final long id;
    public final String manufacturer;
    public final String color;
    public final String engineType;

    public CarDto(long id, String manufacturer, String color, String engineType) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.engineType = engineType;
    }
}
