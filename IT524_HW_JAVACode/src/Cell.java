// Cell Class
public class Cell {
    private Coordinate coordinate;
    private CellStatus status;

    public Cell(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.status = CellStatus.EMPTY;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    public boolean isEmpty() {
        return status == CellStatus.EMPTY;
    }

    public boolean isShip() {
        return status == CellStatus.SHIP;
    }

    public boolean isHit() {
        return status == CellStatus.HIT;
    }

    public boolean isMiss() {
        return status == CellStatus.MISS;
    }

    public boolean isSunk() {
        return status == CellStatus.SUNK;
    }

    public void markHit() {
        status = CellStatus.HIT;
    }

    public void markMiss() {
        status = CellStatus.MISS;
    }

    public void markSunk() {
        status = CellStatus.SUNK;
    }

    public void markEmpty() {
        status = CellStatus.EMPTY;
    }

    public void markShip() {
        status = CellStatus.SHIP;
    }

    public boolean equals(Cell other) {
        return coordinate.equals(other.getCoordinate());
    }

    @Override
    public String toString() {
        return coordinate.toString() + " " + status.toString();
    }
}
