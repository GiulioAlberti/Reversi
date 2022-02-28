import Structure.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinatesTests {
    @Test
    void coordinatesToString(){
        Coordinates coordinates = new Coordinates(5,3);
        assertEquals("5c", coordinates.toString());
    }
    @Test
    void stringCoordinatesToString(){
        Coordinates coordinates = new Coordinates("6f");
        assertEquals("6f", coordinates.toString());
    }
    @Test
    void coordinatesWithDifferentConstructors(){
        Coordinates coordinatesWithInts = new Coordinates(7,7);
        Coordinates coordinatesWithString = new Coordinates("7g");
        assert coordinatesWithInts.equals(coordinatesWithString);
    }
}
