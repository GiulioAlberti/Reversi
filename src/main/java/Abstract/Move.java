package Abstract;

import Structure.*;

import java.util.stream.Stream;

public class Move {
    private final Board board;
    private final Disk disk;
    private final Disk enemyDisk;

    public Move(Board board, Disk disk) {
        this.board = board;
        this.disk = disk;
        this.enemyDisk = new Disk((disk.getStatus()==Status.BLACK)? Status.WHITE : Status.BLACK);
    }

    public Stream<Coordinates> findEnemyPiecesToCaptureOnRight(Coordinates coordinates){
        Stream.Builder<Coordinates> builder=Stream.builder();
        Coordinates updatedCoordinates = coordinates.moveInDirection(Direction.RIGHT,1);
        while(board.getDiskAt(updatedCoordinates).equals(enemyDisk)){
            builder.add(updatedCoordinates);
            updatedCoordinates = updatedCoordinates.moveInDirection(Direction.RIGHT,1);
        }
        return builder.build();
    }

    public boolean canCaptureOnTheRight(Coordinates coordinates) {
        int numberOfDisksToCapture = (int) findEnemyPiecesToCaptureOnRight(coordinates).count();
        return numberOfDisksToCapture>0 && board.getDiskAt(coordinates.moveInDirection(Direction.RIGHT,numberOfDisksToCapture+1)).equals(disk);
    }

}
