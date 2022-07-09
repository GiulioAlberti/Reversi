import Abstract.*;
import Structure.*;
import static Structure.Board.BOARD_SIZE;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinalScoreTests {
    @Test
    void scoreCalculate(){
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
        score.declareFinalScore();
        assertTrue(score.getWhiteScore()==2*BOARD_SIZE && score.getBlackScore()==BOARD_SIZE);
    }
}
