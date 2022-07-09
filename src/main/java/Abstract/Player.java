package Abstract;

import Structure.*;


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
    public abstract Coordinates chooseMove(Move move);
}
