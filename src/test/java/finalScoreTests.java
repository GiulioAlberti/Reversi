import Abstract.*;
import Structure.*;
import static Structure.Board.BOARD_SIZE;

import org.junit.jupiter.api.Test;

public class finalScoreTests {
    @Test
    void scoreCalculate(){
        Board board =new Board();
        for(int row=1; row<=BOARD_SIZE; row++){
            board.setDiskAt(new Coordinates(row,1), Status.BLACK);
            board.setDiskAt(new Coordinates(row,2), Status.WHITE);
            board.setDiskAt(new Coordinates(row,3), Status.WHITE);
        }
        HumanPlayer player1 =new HumanPlayer("playerW",new Disk(Status.WHITE));
        HumanPlayer player2 =new HumanPlayer("playerB",new Disk(Status.BLACK));
        FinalScore score= new FinalScore(board,player1, player2);
        score.pointsCalculator();
        score.declareFinalScore();
        assert(score.getWhiteScore()==2*BOARD_SIZE && score.getBlackScore()==BOARD_SIZE);
    }
}