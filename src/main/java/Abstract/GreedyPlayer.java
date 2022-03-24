package Abstract;

import Structure.Coordinates;
import Structure.Disk;

import java.util.List;

public class GreedyPlayer extends Player{
    public GreedyPlayer(String name, Disk disk) {
        super(name, disk);
    }
    @Override
    public Coordinates chooseMove(Move move){
        List<Coordinates> available= move.availableMoves();
        Coordinates greedyChoice= available.get(0);
        int index=0;
        int numberOfCaptures =move.capturedDisksWith(greedyChoice).size();
        for (int i=0; i<available.size(); i++){
            if(move.capturedDisksWith(available.get(i)).size()>numberOfCaptures){
                index=i;
                numberOfCaptures=move.capturedDisksWith(available.get(i)).size();
            }
        }
        Coordinates chosenCoordinates=available.get(index);
        System.out.println("The chosen move is "+chosenCoordinates);
        return chosenCoordinates;
    }
}
