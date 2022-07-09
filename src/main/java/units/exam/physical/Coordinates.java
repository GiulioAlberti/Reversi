package units.exam.physical;

import static units.exam.physical.Board.BOARD_SIZE;

public class Coordinates {
    private final int row;
    private final int column;

    public Coordinates(int row, int column){
        this.row=row;
        this.column=column;
    }
    public Coordinates(String input){
        this.row=input.charAt(0)-48;
        this.column=(char)(input.charAt(1)-'a'+1);
    }

    public Coordinates moveInDirection(Direction direction, int iterations){
        return new Coordinates(this.row+iterations*direction.getRowUpdate(), this.column+ iterations*direction.getColumnUpdate());
    }
    @Override
    public String toString(){
        return row+""+(char)(column-1+'a');
    }

    public boolean areValid(){
        return (1<=row && row <=BOARD_SIZE && 1<=column && column <=BOARD_SIZE);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates coordinates = (Coordinates) o;

        if (row != coordinates.row) return false;
        return column == coordinates.column;
    }
    @Override
    public int hashCode() {
        return 23*row+column;
    }
}