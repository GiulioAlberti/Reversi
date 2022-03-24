package Abstract;

import Structure.*;

import java.util.Scanner;

import static java.lang.System.lineSeparator;

public class GameLogic {
    protected Scanner sin;
    public GameLogic(Scanner sin){
        this.sin=sin;
    }
    private Player createPlayer(Disk disk){
        int typeOfPlayer = defineTypeOfPlayer();
        String name = getPlayerNameFromInput();
        Player player;
        switch(typeOfPlayer){
            case 1 -> player = new HumanPlayer(name, disk);
            case 2-> player = new GreedyPlayer(name, disk);
            default ->{
                RandomNumberGenerator rng =new RandomNumberGenerator();
                player = new RandomPlayer(name, disk, rng);
            }
        }
        return player;
    }

    private int defineTypeOfPlayer(){
        System.out.println("What type of player do you want? '1' if human, '2' if greedy, other integer if random: ");
        int type;
        type = sin.nextInt();
        return type;
    }

    private String getPlayerNameFromInput(){
        System.out.println("Enter the name for this player: ");
        return sin.next();
    }

    public void initializeGame(){
        Board board = new Board();
        board.othelloSetup();
        Player playerB = createPlayer(new Disk(Status.BLACK));
        Player playerW = createPlayer(new Disk(Status.WHITE));
        turnsSystem(board, playerW, playerB);
    }
    private void turnsSystem(Board board, Player playerW, Player playerB){
        int turn=0;
        int passCounter=0;
        System.out.println(board);
        do{
            turn+=1;
            Player currentPlayer=(turn%2==1)?playerB:playerW;
            System.out.println("It's "+currentPlayer.getName()+"'s turn."+lineSeparator());
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
