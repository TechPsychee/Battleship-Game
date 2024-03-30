public class GameEngine {
    private Player humanPlayer;
    private Player computerPlayer;
    private GameBoard gameBoard; // Add this line to declare the gameBoard variable
    private Player currentPlayer; // Add this line to declare the currentPlayer variable

    public GameEngine(Player humanPlayer, Player computerPlayer) {
        this.humanPlayer = humanPlayer;
        this.computerPlayer = computerPlayer;
    }

    public void playGame() {
        // Initialize the game, set up the board, and place ships for both players
        setUpGame();

        // Start the game loop
        while (!isGameOver()) {
            // Display the current player's grid and enemy grid
            displayGrids();

            // Let the current player make a move
            Coordinate target = getCurrentPlayer().makeMove();

            // Process the move and update grids
            boolean hit = gameBoard.receiveAttack(target);

            // Update the player's grid and enemy grid based on the result of the attack
            getCurrentPlayer().updateGrids(hit, target);

            // Check if the game is over
            if (isGameOver()) {
                // Display the final result
                displayGrids();
                System.out.println("Game Over!");
                if (humanPlayer.getFleet().isEmpty()) {
                    System.out.println("Computer Player Wins!");
                } else {
                    System.out.println("Human Player Wins!");
                }
            } else {
                // Switch to the next player for the next turn
                switchPlayer();
            }
        }
    }

    private void setUpGame() {
        // Handle the process of players placing their ships on the board
        humanPlayer.placeShips();
        computerPlayer.placeShips();
    }

    private boolean isGameOver() {
        // Check if either player's fleet is entirely sunk
        return humanPlayer.getFleet().isEmpty() || computerPlayer.getFleet().isEmpty();
    }

    private void displayGrids() {
        // Display the current player's grid and enemy grid
        System.out.println("Human Player Grid:");
        gameBoard.displayPlayerGrid(humanPlayer.getPlayerGrid());
        System.out.println("\nComputer Player Grid:");
        gameBoard.displayOpponentGrid(computerPlayer.getPlayerGrid());
    }

    private Player getCurrentPlayer() {
        // Return the current player (human or computer)
        return (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
    }

    private void switchPlayer() {
        // Switch the current player between human and computer
        currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
    }

    public static void main(String[] args) {
        // Create a new game and start it

        GameEngine gameEngine = new GameEngine(new HumanPlayer(new Grid(10), new Grid(10), null),
                new ComputerPlayer(new Grid(10), new Grid(10), null));

        gameEngine.playGame();

    }

}
