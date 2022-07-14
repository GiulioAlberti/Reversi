package units.exam.logical;
import units.exam.physical.Coordinates;
import units.exam.physical.Disk;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner sin;
    protected HumanPlayer(String name, Disk disk, Scanner sin) {
        super(name, disk);
        this.sin=sin;
    }
    @Override
    protected Coordinates chooseMove(Move move){
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
