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
        this.sin = sin;
    }

    public void initializeGame(){
        Board board = new Board();
        board.othelloSetup();
        PlayerCreator playerCreator = new PlayerCreator(sin);
        Player playerB = playerCreator.createPlayer(new Disk(Status.BLACK));
        Player playerW = playerCreator.createPlayer(new Disk(Status.WHITE));
        turnsSystem(board, playerW, playerB);
    }

    private void turnsSystem(Board board, Player playerW, Player playerB){
        int turn = 0;
        int passCounter = 0;
        System.out.println(board);
        do{
            turn += 1;
            Player currentPlayer = (turn%2 == 1)? playerB:playerW;
            System.out.println("It's "+currentPlayer.getName()+" ("+currentPlayer.getDisk().getStatus()+")"+"'s turn."+lineSeparator());
            Move turnMove = new Move(board, currentPlayer.disk);
            if(turnMove.availableMoves().isEmpty()){
                if(passCounter == 1) break;
                else{
                    passCounter += 1;
                    System.out.println("You don't have any available moves, you need to pass your turn.");
                }
            }
            else {
                passCounter = 0;
                actualTurn(board, currentPlayer, turnMove);
            }
        }while (true);
        endGame(board, playerW, playerB);
        askIfPlayAgain();
    }

    private void actualTurn(Board board, Player currentPlayer, Move turnMove) {
        Coordinates chosenMove = currentPlayer.chooseMove(turnMove);
        turnMove.placeDiskAndCapture(chosenMove);
        System.out.println(board);
    }

    private void endGame(Board board, Player playerW, Player playerB) {
        System.out.println("There are no more available moves for both players! Let's see who won...");
        FinalScore finalScore = new FinalScore(board, playerW, playerB);
        finalScore.pointsCalculator();
        finalScore.declareFinalScore();
    }

    private void askIfPlayAgain() {
        System.out.println("Do you want to play another game? Y = Yes, N = No ");
        boolean anotherMatch = false;
        char type;
        do {
            type = sin.next().charAt(0);
            if (type == 'Y' || type == 'N'){
                if(type == 'Y') anotherMatch = true;
                break;
            }
            System.out.println("That's not an option! Y = Yes, N = No");
        }
        while (true);
        if (anotherMatch) initializeGame();
    }
}