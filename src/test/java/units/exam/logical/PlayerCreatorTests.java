package units.exam.logical;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerCreatorTests {
    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3", "25, 2","32222, 3"})
    void testTypeDefinition(String input, char expectedChar){
        ByteArrayInputStream fakeScanner = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        PlayerCreator playerCreator = new PlayerCreator(new Scanner(fakeScanner));
        ByteArrayOutputStream fakeStandardOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeStandardOutput));
        char type = playerCreator.defineTypeOfPlayer();
        assertEquals("What type of player do you want? '1' if human, '2' if greedy, '3' if random: "+System.lineSeparator(), fakeStandardOutput.toString());
        assertEquals(type,expectedChar);
    }
}
