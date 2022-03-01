import Abstract.*;
import Structure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    @Test
    void canCaptureEnemyPiecesOnTheRight(){
        Board board =new Board();
        board.othelloSetup();
        Coordinates coordinates= new Coordinates(5,3);
        Disk disk = new Disk(Status.BLACK);
        Move move=new Move(board, disk);
        boolean response= move.canCaptureOnTheRight(coordinates);
        assertTrue(response);

    }

}
