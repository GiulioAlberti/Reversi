package units.exam.logical;

import units.exam.physical.Board;
import units.exam.physical.Coordinates;
import units.exam.physical.Disk;
import units.exam.physical.Status;

import java.util.Scanner;

import static java.lang.System.lineSeparator;

public class GameLogic {
    protected Scanner sin;
    public GameLogic(Scanner sin){
        this.sin=sin;
    }
    public void initializeGame(){
        Board board = new Board();
        board.othelloSetup();
        PlayerCreator playerCreator=new PlayerCreator(sin);
        Player playerB = playerCreator.createPlayer(new Disk(Status.BLACK));
        Player playerW = playerCreator.createPlayer(new Disk(Status.WHITE));
        turnsSystem(board, playerW, playerB);
    }
    private void turnsSystem(Board board, Player playerW, Player playerB){
        int turn=0;
        int passCounter=0;
        System.out.println(board);
        do{
            turn+=1;
            Player currentPlayer=(turn%2==1)?playerB:playerW;
            System.out.println("It's "+currentPlayer.getName()+" ("+currentPlayer.getDisk().getStatus()+")"+"'s turn."+lineSeparator());
            Move turnMove=new Move(board, currentPlayer.disk);
            if(turnMove.availableMoves().isEmpty()){
                if(passCounter==1) break;
                else{
                    passCounter+=1;
                    System.out.println("You don't have any available moves, you need to pass your turn.");
                }
            }
            else {
                passCounter=0;
                Coordinates chosenMove=currentPlayer.chooseMove(turnMove);
                turnMove.placeDiskAndCapture(chosenMove);
                System.out.println(board);
            }
        }while (true);
        FinalScore finalScore=new FinalScore(board,playerW,playerB);
        finalScore.pointsCalculator();
        finalScore.declareFinalScore();
    }
}
