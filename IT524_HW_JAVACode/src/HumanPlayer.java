import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    Scanner getScanner() {
        return scanner;
    }

    Scanner setScanner(Scanner scanner) {
        return this.scanner = scanner;
    }

    public HumanPlayer(Grid playerGrid, Grid enemyGrid, List<Ship> fleet) {
        super(playerGrid, enemyGrid, fleet);
        scanner = new Scanner(System.in);
    }

    @Override
    public void placeShips() {
        // Implement human player's ship placement logic here

        // we can use scanner to take user input for placing ships

    }

    @Override
    public Coordinate makeMove() {
        // Implement human player's move logic here
        // we can use scanner to take user input for making a move
        // Return the Coordinate representing the move
        return new Coordinate(0, 0); // Example return value, replace with actual logic
    }

}
