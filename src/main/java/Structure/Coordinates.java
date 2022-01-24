package Structure;

import static Structure.Board.BOARD_SIZE;

public class Coordinates {
    private final int row;
    private final int column;

    public Coordinates(int row, int column){
        this.row=row;
        this.column=column;
    }
    public Coordinates(String input){
        this.row=input.charAt(1);
        this.column=input.charAt(0)-'a';
    }

    public int get_row(){
        return row;
    }
    public int get_column(){
        return column;
    }

    @Override
    public String toString(){
        return (column+'a')+""+row;
    }

    public boolean areValid(){
        return (1<=row && row <=BOARD_SIZE && 1<=column && column <=BOARD_SIZE);
    }

}