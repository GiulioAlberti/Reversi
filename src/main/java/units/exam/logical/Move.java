package units.exam.logical;

import units.exam.physical.*;

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
        this.enemyDisk = new Disk((disk.getStatus() == Status.BLACK)? Status.WHITE : Status.BLACK);
    }

    protected Stream<Coordinates> findEnemyPiecesToCapture(Coordinates coordinates, Direction direction){
        Stream.Builder<Coordinates> builder = Stream.builder();
        Coordinates updatedCoordinates = coordinates.moveInDirection(direction,1);
        while(updatedCoordinates.areValid() && board.getDiskAt(updatedCoordinates).equals(enemyDisk)){
            builder.add(updatedCoordinates);
            updatedCoordinates = updatedCoordinates.moveInDirection(direction,1);
        }
        return builder.build();
    }

    protected boolean canCaptureInAGivenDirection(Coordinates coordinates, Direction direction) {
        int numberOfDisksToCapture = (int) findEnemyPiecesToCapture(coordinates, direction).count();
        if(!coordinates.moveInDirection(direction,numberOfDisksToCapture+1).areValid()){
            return false;
        }
        return numberOfDisksToCapture > 0 && board.getDiskAt(coordinates.moveInDirection(direction,numberOfDisksToCapture+1)).equals(disk);
    }

    protected boolean isCandidateMove(Coordinates coordinates){
        return board.getDiskAt(coordinates).isEmpty() && Stream.of(Direction.values())
                .anyMatch(direction -> canCaptureInAGivenDirection(coordinates,direction));
    }

    protected List<Coordinates> availableMoves(){
        return board.coordinatesSet().stream().filter(this::isCandidateMove).collect(Collectors.toList());
    }

    protected List<Coordinates> capturedDisksWith(Coordinates coordinates){
        return Stream.of(Direction.values()).filter(direction -> canCaptureInAGivenDirection(coordinates,direction))
                .flatMap(direction -> findEnemyPiecesToCapture(coordinates, direction)).collect(Collectors.toList());
    }

    protected void placeDiskAndCapture(Coordinates coordinates){
        List<Coordinates> enemyCapturedDisks = capturedDisksWith(coordinates);
        board.setDiskAt(coordinates,disk.getStatus());
        for (Coordinates enemyCoordinates : enemyCapturedDisks){
            board.setDiskAt(enemyCoordinates, disk.getStatus());
        }
    }
}
