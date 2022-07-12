package units.exam.logical;

import units.exam.physical.Coordinates;
import units.exam.physical.Disk;

import java.util.List;

public class GreedyPlayer extends Player {
    protected GreedyPlayer(String name, Disk disk) {
        super(name, disk);
    }
    @Override
    protected Coordinates chooseMove(Move move){
        List<Coordinates> available= move.availableMoves();
        int maxCaptures= available.stream().mapToInt(coordinates -> move.capturedDisksWith(coordinates).size()).max().orElse(-1);
        Coordinates chosenCoordinates= available.stream().parallel().filter(coordinates -> move.capturedDisksWith(coordinates).size()==maxCaptures).findAny().orElseThrow(() -> new RuntimeException("No Such Element"));
        System.out.println("The chosen move is "+chosenCoordinates);
        return chosenCoordinates;
    }
}
