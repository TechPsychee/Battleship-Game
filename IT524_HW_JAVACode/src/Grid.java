public class Grid {
    private Cell[][] cells;

    public Grid(int gridSize) {
        cells = new Cell[gridSize][gridSize];

        // Initialize cells with empty status
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                cells[x][y] = new Cell(new Coordinate(x, y));
            }
        }
    }

    // method for getCell(coordinate: Coordinate): Cell - Returns the cell at the
    // given coordinate.

    public Cell getCell(Coordinate coordinate) {
        return cells[coordinate.getX()][coordinate.getY()];
    }

    // method for markHit(target: Coordinate): void - Marks a cell as hit.

    public void markHit(Coordinate target) {
        cells[target.getX()][target.getY()].setStatus(CellStatus.HIT);
    }

    // method for markMiss(target: Coordinate): void - Marks a cell as miss.

    public void markMiss(Coordinate target) {
        cells[target.getX()][target.getY()].setStatus(CellStatus.MISS);
    }

    // method for markSunk(target: Coordinate): void - Marks a cell as sunk.

    public void markSunk(Coordinate target) {
        cells[target.getX()][target.getY()].setStatus(CellStatus.SUNK);
    }

    // method for markEmpty(target: Coordinate): void - Marks a cell as empty.

    public void markEmpty(Coordinate target) {
        cells[target.getX()][target.getY()].setStatus(CellStatus.EMPTY);
    }

    // method for markShip(target: Coordinate): void - Marks a cell as ship.

    public void markShip(Coordinate target) {
        cells[target.getX()][target.getY()].setStatus(CellStatus.SHIP);
    }

    // method for • isValidPlacement(ship: Ship, coordinates: Coordinate[]): boolean
    // - Checks if a given coordinate is a valid placement for a ship.

    public boolean isValidPlacement(Ship ship, Coordinate[] coordinates) {
        // Check if the coordinates are within valid bounds of the grid
        for (Coordinate coordinate : coordinates) {
            if (!coordinate.isValid()) {
                return false;
            }
        }

        // Check if the coordinates are contiguous
        for (int i = 0; i < coordinates.length - 1; i++) {
            Coordinate current = coordinates[i];
            Coordinate next = coordinates[i + 1];

            if (current.getX() != next.getX() && current.getY() != next.getY()) {
                return false;
            }
        }

        // Check if the coordinates are empty
        for (Coordinate coordinate : coordinates) {
            if (!cells[coordinate.getX()][coordinate.getY()].isEmpty()) {
                return false;
            }
        }

        return true;
    }

    // method for • placeShip(ship: Ship, coordinates: Coordinate[]): boolean

    public boolean placeShip(Ship ship, Coordinate[] coordinates) {
        // Check if the coordinates are valid for ship placement
        if (ship == null || coordinates == null || coordinates.length != ship.getSize()) {
            return false; // Invalid placement
        }

        // Check if the coordinates are valid for ship placement
        if (!isValidPlacement(ship, coordinates)) {
            return false; // Invalid placement
        }

        // Place the ship on the grid
        for (Coordinate coordinate : coordinates) {
            cells[coordinate.getX()][coordinate.getY()].setStatus(CellStatus.SHIP);
        }

        return true;
    }

    public boolean isCoordinateInGrid(Coordinate target) {
        return false;
    }

    public boolean receiveAttack(Coordinate target) {
        return false;
    }

}
