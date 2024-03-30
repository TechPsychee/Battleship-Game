import java.util.List;

public class ComputerPlayer extends Player {
    public ComputerPlayer(Grid playerGrid, Grid enemyGrid, List<Ship> fleet) {
        super(playerGrid, enemyGrid, fleet);
    }

    @Override
    public void placeShips() {
        // Implement computer player's ship placement logic here
    }

    @Override
    public Coordinate makeMove() {
        // Implement computer player's move logic here
        // Return the Coordinate representing the move
        return new Coordinate(0, 0); // Example return value, replace with actual logic
    }

}
