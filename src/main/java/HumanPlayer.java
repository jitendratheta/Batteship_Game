import java.util.Scanner;

/**
 * The type Human player.
 */
public class HumanPlayer extends Player {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Instantiates a new Human player.
     *
     * @param board the myBoard
     */
    public HumanPlayer(Board board) {
        super(board);
    }

    @Override
    public Position play() {
        boolean valid = false;
        while (!valid) {
            String input = scanner.nextLine();
            if(!isValid(input)) {
                System.out.println("Invalid input poistion given. try again");
                continue;
            }
            return Util.getPosition(input);
        }
        return null;
    }

    @Override
    public void placeShip(Ship.ShipType shipType) throws Exception {
        super.placeShip(shipType);
        // NOTE: calling parent to do automatically. Can be done manually also as below
        // TODO: add code in case of manually putting the ship on myBoard by player
    }

    private boolean isValid(String input) {
        if(input == null || input.length() < 2 || input.length() > 2)
            return false;
        if(input.charAt(0) < 'A' || 'Z' < input.charAt(0) || input.charAt(1) < '0' || input.charAt(1) > '9')
            return false;
        return true;
    }
}
