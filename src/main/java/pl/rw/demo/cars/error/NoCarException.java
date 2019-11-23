package pl.rw.demo.cars.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoCarException extends Exception {
    public NoCarException(final Long id) {
        super("Car id: " + id + " does not exists!");
    }
}
