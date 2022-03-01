package Structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.System.lineSeparator;

public class Board {
    static final int BOARD_SIZE = 8;
    private final Map<Coordinates, Disk> board = new HashMap<>();

    public Board(){
        for(int row=1; row<=BOARD_SIZE; row++)
            for(int column=1; column<=BOARD_SIZE; column++)
                board.put(new Coordinates(row,column), new Disk(Status.EMPTY));
    }
    public void othelloSetup(){
        setDiskAt(new Coordinates(BOARD_SIZE/2,BOARD_SIZE/2), Status.BLACK);
        setDiskAt(new Coordinates(BOARD_SIZE/2+1,BOARD_SIZE/2+1), Status.BLACK);
        setDiskAt(new Coordinates(BOARD_SIZE/2+1,BOARD_SIZE/2), Status.WHITE);
        setDiskAt(new Coordinates(BOARD_SIZE/2,BOARD_SIZE/2+1), Status.WHITE);
    }
    public Disk getDiskAt(Coordinates coordinates){
        return board.get(coordinates);
    }
    public void setDiskAt(Coordinates coordinates, Status status){
        getDiskAt(coordinates).changeStatusTo(status);
    }

    public Set<Coordinates> coordinatesSet(){
        return board.keySet();
    }

    static final String LINE = "  +---+---+---+---+---+---+---+---+"+lineSeparator();
    static final String SPACE = " ";
    static final String BAR =" | ";
    @Override
    public String toString(){
        StringBuilder boardToString= new StringBuilder(SPACE);
        for(int column=0; column<BOARD_SIZE; column++){
            boardToString.append(SPACE.repeat(3)).append((char)('a' + column));
        }
        boardToString.append(lineSeparator()).append(LINE);
        for(int row=BOARD_SIZE; row>0; row--){
            boardToString.append(row).append(BAR);
            for(int column=1; column<=BOARD_SIZE; column++) {
                boardToString.append(getDiskAt(new Coordinates(row,column)).getStatus().symbol()).append(BAR);
                //this line should be refactored probably
            }
            boardToString.append(lineSeparator()).append(LINE);
        }
        return boardToString.toString();
    }
}
