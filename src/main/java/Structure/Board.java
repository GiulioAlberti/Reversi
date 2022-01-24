package Structure;

import java.util.HashMap;
import java.util.Map;

public class Board {
    static final int BOARD_SIZE = 8;
    private Map<Coordinates, Disk> board = new HashMap<>();

    public Board(){
        for(int row=1; row<=BOARD_SIZE; row++)
            for(int column=1; column<=BOARD_SIZE; column++)
                board.put(new Coordinates(row,column), new Disk(Status.EMPTY));
    }
    public void othelloSetup(){
        setDiskAt(new Coordinates(4,4), Status.BLACK);
        setDiskAt(new Coordinates(5,5), Status.BLACK);
        setDiskAt(new Coordinates(5,4), Status.WHITE);
        setDiskAt(new Coordinates(4,5), Status.WHITE);
    }
    private Disk getDiskAt(Coordinates coordinates){
        return board.get(coordinates);
    }
    public void setDiskAt(Coordinates coordinates, Status status){
        getDiskAt(coordinates).changeStatusTo(status);
    }


}
