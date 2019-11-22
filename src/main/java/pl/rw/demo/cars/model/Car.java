package pl.rw.demo.cars.model;

public class Car {
    public final long id;
    public final String manufacturer;
    public final String color;
    public final String engineType;

    public Car(long id, String manufacturer, String color, String engineType) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.color = color;
        this.engineType = engineType;
    }
}
