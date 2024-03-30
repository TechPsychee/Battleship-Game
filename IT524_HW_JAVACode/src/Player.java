import java.util.List;

public abstract class Player {
    protected Grid playerGrid;
    protected Grid enemyGrid;
    protected List<Ship> fleet;

    public Player(Grid playerGrid, Grid enemyGrid, List<Ship> fleet) {
        this.playerGrid = playerGrid;
        this.enemyGrid = enemyGrid;
        this.fleet = fleet;
    }

    public Grid getPlayerGrid() {
        return playerGrid;
    }

    public Grid getEnemyGrid() {
        return enemyGrid;
    }

    public List<Ship> getFleet() {
        return fleet;
    }

    public abstract void placeShips();

    public abstract Coordinate makeMove();

    public boolean isDefeated() {
        for (Ship ship : fleet) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public void markHit(Coordinate target) {
        for (Ship ship : fleet) {
            if (ship.isHit(target)) {
                ship.markHit(target);
                if (ship.isSunk()) {
                    ship.markSunk();
                }
                return;
            }
        }
    }

    public void markMiss(Coordinate target) {
        for (Ship ship : fleet) {
            if (ship.isHit(target)) {
                ship.markMiss();
                return;
            }
        }
    }

    public void markEmpty(Coordinate target) {
        for (Ship ship : fleet) {
            if (ship.isHit(target)) {
                ship.markEmpty();
                return;
            }
        }
    }

    public void markShip(Coordinate target) {
        for (Ship ship : fleet) {
            if (ship.isHit(target)) {
                ship.markShip();
                return;
            }
        }
    }

    public void markSunk(Coordinate target) {
        for (Ship ship : fleet) {
            if (ship.isHit(target)) {
                ship.markSunk();
                return;
            }
        }
    }

    public boolean isValidPlacement(Ship ship, Coordinate[] coordinates) {
        // Check if the coordinates are within valid bounds of the grid
        for (Coordinate coordinate : coordinates) {
            if (!coordinate.isValid()) {
                return false;
            }
        }

        // Check if the coordinates are adjacent
        for (int i = 0; i < coordinates.length - 1; i++) {
            Coordinate current = coordinates[i];
            Coordinate next = coordinates[i + 1];

            if (current.getX() != next.getX() && current.getY() != next.getY()) {
                return false;
            }
        }

        // Check if the coordinates are empty
        for (Coordinate coordinate : coordinates) {
            if (!playerGrid.getCell(coordinate).isEmpty()) {
                return false;
            }
        }

        return true;
    }

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
            playerGrid.getCell(coordinate).setStatus(CellStatus.SHIP);
        }

        return true;
    }

    public void updateGrids(boolean hit, Coordinate target) {
        if (hit) {
            enemyGrid.getCell(target).setStatus(CellStatus.HIT);
            playerGrid.getCell(target).setStatus(CellStatus.HIT);
        } else {
            enemyGrid.getCell(target).setStatus(CellStatus.MISS);
            playerGrid.getCell(target).setStatus(CellStatus.MISS);
        }
    }

    // set fleet

    public void setFleet(List<Ship> fleet) {
        this.fleet = fleet;
    }

}
