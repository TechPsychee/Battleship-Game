import java.util.List;

// Ship Abstract Class
public abstract class Ship {
    private int size;
    private List<Coordinate> coordinates;

    // Constructor
    public Ship(int size, List<Coordinate> coordinates) {
        this.size = size;
        this.coordinates = coordinates;
    }

    // Getters
    public int getSize() {
        return size;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    // setters

    public void setSize(int size) {
        this.size = size;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    // Methods

    public abstract boolean isSunk();

    public boolean isHit(Coordinate target) {
        // Check if the given coordinate is part of this ship's coordinates
        return coordinates.contains(target);
    }

    public void markHit(Coordinate target) {
        // Mark the given coordinate as hit
        coordinates.remove(target);
    }

    public void markSunk() {
        // Mark all coordinates as hit
        coordinates.clear();
    }

    public void markEmpty() {
        // Reset all coordinates
        coordinates.clear();
    }

    public void markShip() {
        // Reset all coordinates
        coordinates.clear();
    }

    public void markMiss() {
        // Reset all coordinates
        coordinates.clear();
    }

}
