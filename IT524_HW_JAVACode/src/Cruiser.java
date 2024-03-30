import java.util.List;

// Cruiser Class (extends Ship)
public class Cruiser extends Ship {
    public Cruiser(List<Coordinate> coordinates) {
        super(2, coordinates); // Cruiser has a size of 2
    }

    @Override
    public boolean isSunk() {
        // A cruiser is sunk if all its coordinates are hit
        return getCoordinates().isEmpty();
    }
}