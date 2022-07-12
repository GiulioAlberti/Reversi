package units.exam.logical;

import units.exam.physical.Coordinates;
import units.exam.physical.Disk;


public abstract class Player {
    private final String name;
    protected final Disk disk;

    protected Player(String name, Disk disk) {
        this.name = name;
        this.disk = disk;
    }
    public Disk getDisk() {
        return disk;
    }
    public String getName() {
        return name;
    }
    protected abstract Coordinates chooseMove(Move move);
}
