public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int gridSize = 10; // Assuming gridSize is 10, you can change it to the desired value

    public boolean isValid() {
        // Check if the coordinates are within valid bounds of the grid
        return x >= 0 && x < gridSize && y >= 0 && y < gridSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
