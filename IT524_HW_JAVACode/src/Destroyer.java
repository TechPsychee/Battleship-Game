import java.util.List;

// Destroyer Class (extends Ship)
public class Destroyer extends Ship {
    public Destroyer(List<Coordinate> coordinates) {
        super(3, coordinates); // Destroyer has a size of 3
    }

    @Override
    public boolean isSunk() {
        // A destroyer is sunk if all its coordinates are hit
        return getCoordinates().isEmpty();
    }
}
