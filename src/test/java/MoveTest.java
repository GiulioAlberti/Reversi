import Abstract.*;
import Structure.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    @Test
    void canCaptureEnemyPiecesOnTheRight(){
        Board board =new Board();
        board.othelloSetup();
        Coordinates coordinates= new Coordinates(5,3);
        Disk disk = new Disk(Status.BLACK);
        Move move=new Move(board, disk);
        boolean response= move.canCaptureInAGivenDirection(coordinates, Direction.RIGHT);
        assertTrue(response);

    }
    @Test
    void canCaptureEnemyPiecesUp(){
        Board board =new Board();
        board.othelloSetup();
        Coordinates coordinates= new Coordinates(3,4);
        Disk disk = new Disk(Status.WHITE);
        Move move=new Move(board, disk);
        boolean response= move.canCaptureInAGivenDirection(coordinates, Direction.UP);
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
        List<Coordinates> correct = new ArrayList<>();
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
}
