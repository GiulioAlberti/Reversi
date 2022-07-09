import Abstract.*;
import Structure.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        String input = "5c";
        ByteArrayInputStream fakeScanner = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        HumanPlayer player =new HumanPlayer("Giulio", disk, new Scanner(fakeScanner));
        Coordinates chosenMove= player.chooseMove(move);
        Coordinates expected=new Coordinates("5c");
        assertEquals(expected, chosenMove);
    }
    @ParameterizedTest
    @CsvSource({"5, 3, 5b", "6, 4, 7d", "3, 5, 2e"})
    void greedyPlayerMove(int row, int column, String coordinates){
        Board board =new Board();
        board.othelloSetup();
        Disk disk = new Disk(Status.BLACK);
        board.setDiskAt(new Coordinates(row,column), Status.WHITE);
        Move move=new Move(board, disk);
        GreedyPlayer player =new GreedyPlayer("Greedy", disk);
        Coordinates chosenMove= player.chooseMove(move);
        Coordinates expected=new Coordinates(coordinates);
        assertEquals(expected, chosenMove);
    }
    @Test
    void randomPlayerMove(){
        Board board =new Board();
        board.othelloSetup();
        Disk disk = new Disk(Status.BLACK);
        Move move=new Move(board, disk);
        RandomNumberGenerator rng= new RandomNumberGenerator();
        RandomPlayer player =new RandomPlayer("Random", disk, rng);
        Coordinates chosenMove= player.chooseMove(move);
        assert(move.availableMoves().contains(chosenMove));
    }
}