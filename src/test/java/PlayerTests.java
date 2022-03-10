import Abstract.*;
import Structure.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTests {
    @Test
    void humanPlayerMove(){
        Board board =new Board();
        board.othelloSetup();
        Disk disk = new Disk(Status.BLACK);
        Move move=new Move(board, disk);
        HumanPlayer player =new HumanPlayer("Giulio", disk);
        String input = "5c";
        ByteArrayInputStream fakeScanner = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        HumanPlayer.setScanner(new Scanner(fakeScanner));
        Coordinates chosenMove= player.chooseMove(move);
        Coordinates expected=new Coordinates("5c");
        assertEquals(expected, chosenMove);
    }
}
