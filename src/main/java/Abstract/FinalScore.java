package Abstract;

import Structure.*;
import static Structure.Board.BOARD_SIZE;

public class FinalScore {
    private final Board board;
    private final Player whitePlayer;
    private final Player blackPlayer;
    private int blackScore;
    private int whiteScore;

    public FinalScore(Board board, Player whitePlayer, Player blackPlayer){
        this.board=board;
        this.whitePlayer=whitePlayer;
        this.blackPlayer=blackPlayer;
        this.whiteScore=0;
        this.blackScore=0;
    }

    public int getBlackScore() {
        return blackScore;
    }

    public int getWhiteScore() {
        return whiteScore;
    }

    public void pointsCalculator(){
        for(int row=1; row<=BOARD_SIZE; row++){
            for(int column=1; column<=BOARD_SIZE; column++){
                Status currentStatus=board.getStatusAt(new Coordinates(row,column));
                switch (currentStatus){
                    case WHITE -> whiteScore+=1;
                    case BLACK -> blackScore+=1;
                    case EMPTY ->{}
                }
            }
        }
    }

    public void declareFinalScore(){
        if(whiteScore==blackScore){
            System.out.println("It's a tie!");
        }
        else{
            String winnerName=(whiteScore>blackScore)? whitePlayer.getName() : blackPlayer.getName();
            System.out.println("The winner is "+winnerName+" and the final score is: "+whiteScore+" W-B "+blackScore);
        }
    }
}
