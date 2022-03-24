package Abstract;
import Structure.*;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{
    private static Scanner sin;
    public static void setScanner(Scanner sin) {
        HumanPlayer.sin = sin;
    }
    public HumanPlayer(String name, Disk disk) {
        super(name, disk);
        Scanner sin = new Scanner(System.in);
        setScanner(sin);
    }
    @Override
    public Coordinates chooseMove(Move move){
        System.out.println(getName()+" please enter the coordinates for your move:");
        String stringInput;
        Coordinates coordinates;
        List<Coordinates> available=move.availableMoves();
        do{
            stringInput=sin.nextLine();
            if(stringInput.length()<2){
                System.out.println("The coordinates must be of the form '1a'. ");
            }
            else{
                coordinates=new Coordinates(stringInput);
                if(!coordinates.areValid() || !available.contains(coordinates))
                    System.out.println("Invalid input or position");
                else
                    break;}
        } while(true);
        return coordinates;
    }
}
