package units.exam.logical;

import units.exam.physical.Coordinates;
import units.exam.physical.Disk;


public abstract class Player {
    private final String name;
    protected final Disk disk;

    public Player(String name, Disk disk) {
        this.name = name;
        this.disk = disk;
    }
    public Disk getDisk() {
        return disk;
    }
    public String getName() {
        return name;
    }
    public abstract Coordinates chooseMove(Move move);
}
