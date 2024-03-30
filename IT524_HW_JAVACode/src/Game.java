import java.util.List;
import java.util.ArrayList;

public class Game {
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private Player currentPlayer;
    private GameBoard gameBoard;

    public Game() {
        // Initialize the game components
        humanPlayer = new HumanPlayer(new Grid(10), new Grid(10), createFleet());
        computerPlayer = new ComputerPlayer(new Grid(10), new Grid(10), createFleet());
        currentPlayer = humanPlayer; // Start with the human player
        gameBoard = new GameBoard(humanPlayer.getPlayerGrid(), computerPlayer.getPlayerGrid());
    }

    public void startGame() {
        // Initialize the game and place ships for both players

        setUpShips();

        // Start the game loop

    }

    public void switchPlayer() {
        // Switch the current player between human and computer
        currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
    }

    public boolean checkGameOver() {
        // Check if either player's fleet is entirely sunk
        return humanPlayer.getFleet().isEmpty() || computerPlayer.getFleet().isEmpty();
    }

    public void setUpShips() {
        // Handle the process of players placing their ships on the board
        humanPlayer.placeShips();
        computerPlayer.placeShips();
    }

    public void displayGrids() {
        // Display the current player's grid and enemy grid
        System.out.println("Human Player Grid:");
        gameBoard.displayPlayerGrid(humanPlayer.getPlayerGrid());
        System.out.println("\nComputer Player Grid:");
        gameBoard.displayOpponentGrid(computerPlayer.getPlayerGrid());
    }

    private List<Ship> createFleet() {
        // Create and return a list of ships for each player's fleet
        List<Ship> fleet = new ArrayList<>();
        fleet.add(new Battleship(new ArrayList<>()));
        fleet.add(new Cruiser(new ArrayList<>()));
        fleet.add(new Cruiser(new ArrayList<>()));
        fleet.add(new Destroyer(new ArrayList<>()));
        fleet.add(new Destroyer(new ArrayList<>()));
        fleet.add(new Destroyer(new ArrayList<>()));
        fleet.add(new Submarine(new ArrayList<>()));
        fleet.add(new Submarine(new ArrayList<>()));
        fleet.add(new Submarine(new ArrayList<>()));
        fleet.add(new Submarine(new ArrayList<>()));
        return fleet;
    }

    public static void main(String[] args) {
        // Create a new game and start it

        Game game = new Game();
        game.startGame();

    }

}
