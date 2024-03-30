import java.util.List;

public class Battleship extends Ship {
    public Battleship(List<Coordinate> coordinates) {
        super(4, coordinates); // Battleship has a size of 4
    }

    @Override
    public boolean isSunk() {
        // A battleship is sunk if all its coordinates are hit
        return getCoordinates().isEmpty();
    }

    @Override
    public void markHit(Coordinate target) {
        // Mark the given coordinate as hit
        super.markHit(target);
    }

}
