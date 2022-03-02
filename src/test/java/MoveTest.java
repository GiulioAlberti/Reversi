import Abstract.*;
import Structure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    @ParameterizedTest
    @CsvSource({"RIGHT, 5c", "DOWN, 6d", "LEFT, 4f", "UP, 3e"})
    void canCaptureEnemyPiecesInADirection(Direction direction, String addedDisk){
        Board board =new Board();
        board.othelloSetup();
        Coordinates coordinates= new Coordinates(addedDisk);
        Disk disk = new Disk(Status.BLACK);
        Move move=new Move(board, disk);
        boolean response= move.canCaptureInAGivenDirection(coordinates, direction);
        assertTrue(response);
    }
    @Test
    void firstAvailableMoves(){
        Board board =new Board();
        board.othelloSetup();
        Disk disk = new Disk(Status.BLACK);
        Move move=new Move(board, disk);
        List<Coordinates> listOfOptions = move.availableMoves();
        List<Coordinates> correct = new ArrayList<>();
        correct.add(new Coordinates("4f"));
        correct.add(new Coordinates("3e"));
        correct.add(new Coordinates("5c"));
        correct.add(new Coordinates("6d"));
        assert(listOfOptions.containsAll(correct) && correct.containsAll(listOfOptions));
    }
    @Test
    void noAvailableMoves(){
        Board board =new Board();
        Disk disk = new Disk(Status.WHITE);
        board.setDiskAt(new Coordinates("4c"),Status.WHITE);
        board.setDiskAt(new Coordinates("4d"),Status.BLACK);
        board.setDiskAt(new Coordinates("4e"),Status.WHITE);
        Move move=new Move(board, disk);
        List<Coordinates> listOfOptions = move.availableMoves();
        assert(listOfOptions.isEmpty());

    }
    @Test
    void diagonallyAvailableMoves(){
        Board board =new Board();
        Disk disk = new Disk(Status.BLACK);
        board.setDiskAt(new Coordinates("2b"),Status.WHITE);
        board.setDiskAt(new Coordinates("3c"),Status.BLACK);
        board.setDiskAt(new Coordinates("4b"),Status.WHITE);
        board.setDiskAt(new Coordinates("4d"),Status.WHITE);
        board.setDiskAt(new Coordinates("2d"),Status.WHITE);
        Move move=new Move(board, disk);
        List<Coordinates> listOfOptions = move.availableMoves();
        List<Coordinates> correct = new ArrayList<>();
        correct.add(new Coordinates("1a"));
        correct.add(new Coordinates("1e"));
        correct.add(new Coordinates("5a"));
        correct.add(new Coordinates("5e"));
        assert(listOfOptions.containsAll(correct) && correct.containsAll(listOfOptions));
    }
    @Test
    void listOfCapturedDisks(){
        Board board =new Board();
        Disk disk = new Disk(Status.BLACK);
        board.setDiskAt(new Coordinates("6b"),Status.BLACK);
        board.setDiskAt(new Coordinates("4d"),Status.BLACK);
        board.setDiskAt(new Coordinates("2d"),Status.BLACK);
        for(int i=3; i<6; i++){
            board.setDiskAt(new Coordinates(i,2),Status.WHITE);
        }
        for(int i=2; i<4; i++){
            board.setDiskAt(new Coordinates(i,3),Status.WHITE);
        }
        Move move=new Move(board, disk);
        List<Coordinates> listOfCaptured = move.capturedDisks(new Coordinates("2b"));
        List<Coordinates> correct = new ArrayList<>();
        correct.add(new Coordinates("3b"));
        correct.add(new Coordinates("4b"));
        correct.add(new Coordinates("5b"));
        correct.add(new Coordinates("2c"));
        correct.add(new Coordinates("3c"));
        assert(listOfCaptured.containsAll(correct) && correct.containsAll(listOfCaptured));
    }
    @Test
    void firstCapture() throws URISyntaxException, IOException {
        URL file= getClass().getClassLoader().getResource("FirstMove");
        assert file != null;
        String boardString = Files.readString(Path.of(file.toURI()));
        Board board =new Board();
        board.othelloSetup();
        Disk disk = new Disk(Status.BLACK);
        Move move=new Move(board, disk);
        move.placeDiskAndCapture(new Coordinates("5c"));
        assertEquals(boardString, board.toString());
    }
}