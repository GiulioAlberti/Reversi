import Abstract.*;
import Structure.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        List<Coordinates> listOfOptions= move.availableMoves();
        StringBuilder moves= new StringBuilder();
        for (Coordinates coord : listOfOptions) {
            moves.append(coord.toString());
        }
        assert(moves.toString().equals("4f5c6d3e"));
    }
}
