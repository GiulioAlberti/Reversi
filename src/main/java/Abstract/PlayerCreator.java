package Abstract;

import Structure.Disk;

import java.util.Scanner;

public class PlayerCreator {
    protected Scanner sin;
    public PlayerCreator(Scanner sin){
        this.sin=sin;
    }
    Player createPlayer(Disk disk){
        char typeOfPlayer = defineTypeOfPlayer();
        String name = getPlayerNameFromInput();
        Player player;
        switch(typeOfPlayer){
            case '1'-> player = new HumanPlayer(name, disk, sin);
            case '2'-> player = new GreedyPlayer(name, disk);
            case '3'->{
                RandomNumberGenerator rng =new RandomNumberGenerator();
                player = new RandomPlayer(name, disk, rng);
            }
            default ->throw new IllegalStateException("Unexpected character");
        }
        return player;
    }
    private char defineTypeOfPlayer(){
        System.out.println("What type of player do you want? '1' if human, '2' if greedy, '3' if random: ");
        char type;
        do {
            type = sin.next().charAt(0);
            if (type == '1' || type == '2' || type == '3')
                break;
            System.out.println("That's not an option! Please try again ");
        }
        while (true);
        return type;
    }
    private String getPlayerNameFromInput(){
        System.out.println("Enter the name for this player: ");
        return sin.next();
    }
}
