public class GameBoard {
    private Grid humanGrid;
    private Grid computerGrid;

    public GameBoard(Grid humanGrid, Grid computerGrid) {
        this.humanGrid = humanGrid;
        this.computerGrid = computerGrid;
    }

    public Grid getHumanGrid() {
        return humanGrid;
    }

    public Grid getComputerGrid() {
        return computerGrid;
    }

    public void setHumanGrid(Grid humanGrid) {
        this.humanGrid = humanGrid;
    }

    public void setComputerGrid(Grid computerGrid) {
        this.computerGrid = computerGrid;
    }

    public boolean placeShip(Player player, Ship ship, Coordinate[] coordinates) {
        // Check if the coordinates are valid for ship placement
        if (player == null || ship == null || coordinates == null || coordinates.length != ship.getSize()) {
            return false; // Invalid placement
        }

        // Check if the player's grid is the human grid or computer grid
        Grid playerGrid = (player instanceof HumanPlayer) ? humanGrid : computerGrid;

        // Attempt to place the ship on the grid
        boolean placedSuccessfully = playerGrid.placeShip(ship, coordinates);

        return placedSuccessfully;
    }

    public boolean receiveAttack(Coordinate target) {
        // Check if the target coordinate is valid
        Player humanPlayer = new HumanPlayer(computerGrid, computerGrid, null); // Initialize humanPlayer
        Player computerPlayer = new ComputerPlayer(computerGrid, computerGrid, null); // Initialize computerPlayer

        if (target == null || !target.isValid()) {
            return false; // Invalid target
        }

        // Determine which player's grid is being attacked (human or computer)
        Player currentPlayer = humanGrid.isCoordinateInGrid(target) ? humanPlayer : computerPlayer;
        Grid currentPlayerGrid = humanGrid.isCoordinateInGrid(target) ? humanGrid : computerGrid;

        // Check if the attack is successful (hit) or not (miss)
        boolean hit = currentPlayerGrid.receiveAttack(target);

        // Update the player's and opponent's grids based on the result of the attack
        currentPlayer.updateGrids(hit, target);

        return hit; // Return true if it's a hit, false if it's a miss
    }

    public void displayPlayerGrid(Grid playerGrid) {
        // Display the player's grid
    }

    public void displayOpponentGrid(Grid playerGrid) {
    }

    public void displayGrids() {
        // Display the current player's grid and enemy grid
        System.out.println("Human Player Grid:");
        displayPlayerGrid(humanGrid);
        System.out.println("\nComputer Player Grid:");
        displayPlayerGrid(computerGrid);
    }
}
