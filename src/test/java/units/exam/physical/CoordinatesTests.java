package units.exam.physical;

import units.exam.physical.Coordinates;
import units.exam.physical.Direction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinatesTests {
    @Test
    void coordinatesToString(){
        Coordinates coordinates = new Coordinates(5,3);
        assertEquals("5c", coordinates.toString());
    }
    @ParameterizedTest
    @CsvSource({"6f, 6f", "2e, 2e", "4h, 4h"})
    void stringCoordinatesToString(String coord ,String expected){
        Coordinates coordinates = new Coordinates(coord);
        assertEquals(expected, coordinates.toString());
    }
    @ParameterizedTest
    @CsvSource({"6, 2, 6b", "1, 5, 1e", "4, 8, 4h"})
    void coordinatesWithDifferentConstructors(int row, int column, String string){
        Coordinates coordinatesWithInts = new Coordinates(row,column);
        Coordinates coordinatesWithString = new Coordinates(string);
        assertEquals(coordinatesWithInts,coordinatesWithString);
    }
    @ParameterizedTest
    @CsvSource({"6a, RIGHT, 2, 6c", "1e, UP_LEFT, 3, 4b", "4g, DOWN, 1, 3g"})
    void moveInDirection(String oldCoordinates ,Direction direction, int iterations, String expectedCoordinates){
        Coordinates oldPosition = new Coordinates(oldCoordinates);
        Coordinates newPosition = oldPosition.moveInDirection(direction, iterations);
        Coordinates expectedPosition = new Coordinates(expectedCoordinates);
        assertEquals(expectedPosition, newPosition);
    }
}
