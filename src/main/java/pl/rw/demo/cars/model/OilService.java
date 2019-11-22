package pl.rw.demo.cars.model;

public class OilService {

    public final Long mileage;
    public final String comment;

    public OilService(Long mileage, String comment) {
        this.mileage = mileage;
        this.comment = comment;
    }
}
