package Abstract;

import Structure.*;

import java.util.List;

public class RandomPlayer extends Player{
    private final RandomNumberGenerator rng;
    public RandomPlayer(String name, Disk disk, RandomNumberGenerator rng) {
        super(name, disk);
        this.rng = rng;
    }
    @Override
    public Coordinates chooseMove(Move move){
        List<Coordinates> availableMoves=move.availableMoves();
        Coordinates chosenCoordinates=availableMoves.get(rng.getRandomInteger(availableMoves.size()));
        System.out.println("The chosen move is "+chosenCoordinates);
        return chosenCoordinates;
    }
}