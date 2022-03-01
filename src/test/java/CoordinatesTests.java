import Structure.Coordinates;
import Structure.Direction;
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
    @Test
    void moveInDirection(){
        Coordinates coordinates = new Coordinates(4,4);
        Coordinates coordinatesUpdated = coordinates.moveInDirection(Direction.RIGHT, 2);
        Coordinates expectedCoordinates = new Coordinates(4,6);
        assertEquals(expectedCoordinates, coordinatesUpdated);
    }
}
