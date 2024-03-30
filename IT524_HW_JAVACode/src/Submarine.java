import java.util.List;

public class Submarine extends Ship {
    public Submarine(List<Coordinate> coordinates) {
        super(1, coordinates); // Submarine has a size of 1
    }

    @Override
    public boolean isSunk() {
        // A submarine is sunk if it's hit
        return !getCoordinates().isEmpty();
    }
}
