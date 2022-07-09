package units.exam.physical;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.System.lineSeparator;

public class Board {
    public static final int BOARD_SIZE = 8;
    private final Map<Coordinates, Disk> boardMap = new HashMap<>();

    public Board(){
        for(int row=1; row<=BOARD_SIZE; row++)
            for(int column=1; column<=BOARD_SIZE; column++)
                boardMap.put(new Coordinates(row,column), new Disk(Status.EMPTY));
    }
    public void othelloSetup(){
        setDiskAt(new Coordinates(BOARD_SIZE/2,BOARD_SIZE/2), Status.BLACK);
        setDiskAt(new Coordinates(BOARD_SIZE/2+1,BOARD_SIZE/2+1), Status.BLACK);
        setDiskAt(new Coordinates(BOARD_SIZE/2+1,BOARD_SIZE/2), Status.WHITE);
        setDiskAt(new Coordinates(BOARD_SIZE/2,BOARD_SIZE/2+1), Status.WHITE);
    }
    public Disk getDiskAt(Coordinates coordinates){
        return boardMap.get(coordinates);
    }
    public Status getStatusAt(Coordinates coordinates){
        return getDiskAt(coordinates).getStatus();
    }
    public void setDiskAt(Coordinates coordinates, Status status){
        getDiskAt(coordinates).changeStatusTo(status);
    }

    public Set<Coordinates> coordinatesSet(){
        return boardMap.keySet();
    }

    static final String LINE = "  +"+"---+".repeat(BOARD_SIZE)+lineSeparator();
    static final String SPACE = " ";
    static final String BAR =" | ";
    @Override
    public String toString(){
        StringBuilder boardToString= new StringBuilder(LINE);
        for(int row=BOARD_SIZE; row>0; row--){
            boardToString.append(row).append(BAR);
            for(int column=1; column<=BOARD_SIZE; column++) {
                boardToString.append(getStatusAt(new Coordinates(row,column)).symbol()).append(BAR);
            }
            boardToString.append(lineSeparator()).append(LINE);
        }
        boardToString.append(SPACE);
        for(int column=0; column<BOARD_SIZE; column++){
            boardToString.append(SPACE.repeat(3)).append((char)('a' + column));
        }
        return boardToString.toString();
    }
}
