package Structure;

public enum Direction {
    UP(1, 0),
    UP_RIGHT(1, 1),
    RIGHT(0, 1),
    DOWN_RIGHT(-1, 1),
    DOWN(-1, 0),
    DOWN_LEFT(-1, -1),
    LEFT(0, -1),
    UP_LEFT(1, -1);

    private final int rowUpdate;
    private final int columnUpdate;

    Direction(int rowUpdate, int columnUpdate) {
        this.rowUpdate = rowUpdate;
        this.columnUpdate = columnUpdate;
    }

    public int getRowUpdate() {
        return rowUpdate;
    }

    public int getColumnUpdate() {
        return columnUpdate;
    }
}
