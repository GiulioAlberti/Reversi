package Abstract;

import Structure.*;

import java.util.List;
import java.util.stream.Collectors;
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

    public Stream<Coordinates> findEnemyPiecesToCapture(Coordinates coordinates, Direction direction){
        Stream.Builder<Coordinates> builder=Stream.builder();
        Coordinates updatedCoordinates = coordinates.moveInDirection(direction,1);
        while(updatedCoordinates.areValid() && board.getDiskAt(updatedCoordinates).equals(enemyDisk)){
            builder.add(updatedCoordinates);
            updatedCoordinates = updatedCoordinates.moveInDirection(direction,1);
        }
        return builder.build();
    }

    public boolean canCaptureInAGivenDirection(Coordinates coordinates, Direction direction) {
        int numberOfDisksToCapture = (int) findEnemyPiecesToCapture(coordinates, direction).count();
        return numberOfDisksToCapture>0 && board.getDiskAt(coordinates.moveInDirection(direction,numberOfDisksToCapture+1)).equals(disk);
    }
    public boolean isCandidateMove(Coordinates coordinates){
        return board.getDiskAt(coordinates).isEmpty() && Stream.of(Direction.values())
                .anyMatch(direction -> canCaptureInAGivenDirection(coordinates,direction));
    }

    public List<Coordinates> availableMoves(){
        return board.coordinatesSet().stream().filter(this::isCandidateMove).collect(Collectors.toList());
    }
    public List<Coordinates> capturedDisks(Coordinates coordinates){
        return Stream.of(Direction.values()).filter(direction -> canCaptureInAGivenDirection(coordinates,direction))
                .flatMap(direction -> findEnemyPiecesToCapture(coordinates, direction)).collect(Collectors.toList());
    }
    public void placeDiskAndCapture(Coordinates coordinates){
        List<Coordinates> enemyCapturedDisks = capturedDisks(coordinates);
        board.setDiskAt(coordinates,disk.getStatus());
        for (Coordinates enemyCoordinates : enemyCapturedDisks){
            board.setDiskAt(enemyCoordinates, disk.getStatus());
        }
    }
}
