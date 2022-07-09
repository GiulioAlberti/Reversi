package units.exam.physical;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTests {
    @Test
    void othelloSetup() throws IOException, URISyntaxException {
        URL file= getClass().getClassLoader().getResource("OthelloSetup");
        assert file != null;
        String boardString = Files.readString(Path.of(file.toURI()));
        Board board =new Board();
        board.othelloSetup();
        assertEquals(boardString, board.toString());
    }

    @Test
    void artificialFirstMove() throws IOException, URISyntaxException {
        URL file= getClass().getClassLoader().getResource("FirstMove");
        assert file != null;
        String boardString = Files.readString(Path.of(file.toURI()));
        Board board =new Board();
        board.othelloSetup();
        board.setDiskAt(new Coordinates(5,3), Status.BLACK);
        board.setDiskAt(new Coordinates(5,4), Status.BLACK);
        assertEquals(boardString, board.toString());
    }
}
