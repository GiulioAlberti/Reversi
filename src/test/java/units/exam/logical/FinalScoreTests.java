package units.exam.logical;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static units.exam.physical.Board.BOARD_SIZE;

import org.junit.jupiter.api.Test;
import units.exam.physical.Board;
import units.exam.physical.Coordinates;
import units.exam.physical.Disk;
import units.exam.physical.Status;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FinalScoreTests {
    @Test
    void differentScoreCalculate(){
        Board board =new Board();
        for(int row=1; row<=BOARD_SIZE; row++){
            board.setDiskAt(new Coordinates(row,1), Status.BLACK);
            board.setDiskAt(new Coordinates(row,2), Status.WHITE);
            board.setDiskAt(new Coordinates(row,3), Status.WHITE);
        }
        Scanner sin = new Scanner(System.in);
        HumanPlayer player1 =new HumanPlayer("playerW",new Disk(Status.WHITE), sin);
        HumanPlayer player2 =new HumanPlayer("playerB",new Disk(Status.BLACK),sin);
        FinalScore score= new FinalScore(board,player1, player2);
        score.pointsCalculator();
        ByteArrayOutputStream fakeStandardOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeStandardOutput));
        score.declareFinalScore();
        assertTrue(score.getWhiteScore()==2*BOARD_SIZE && score.getBlackScore()==BOARD_SIZE);
        assertEquals("The winner is playerW! The final score is: 16 W-B 8"+System.lineSeparator(), fakeStandardOutput.toString());
    }
    @Test
    void sameScoreCalculate(){
        Board board =new Board();
        Scanner sin = new Scanner(System.in);
        HumanPlayer player1 =new HumanPlayer("playerW",new Disk(Status.WHITE), sin);
        HumanPlayer player2 =new HumanPlayer("playerB",new Disk(Status.BLACK),sin);
        FinalScore score= new FinalScore(board,player1, player2);
        score.pointsCalculator();
        ByteArrayOutputStream fakeStandardOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(fakeStandardOutput));
        score.declareFinalScore();
        assertEquals("It's a tie!"+System.lineSeparator(), fakeStandardOutput.toString());
    }
}
