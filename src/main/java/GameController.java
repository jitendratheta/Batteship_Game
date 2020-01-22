import com.google.common.annotations.VisibleForTesting;

/**
 * The type Game controller class. It have the board initialization and game loop logic
 */
public class GameController {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        // NOTE: enable myBoard printing if debug is enabled
        // by default is enabled for now
        if(args.length > 0 && args[0].equals(Constants.COMMANDLINE_ARG_DEBUG)) {
            Constants.DEBUG_MODE = true;
        }

        // NOTE: in case run as bot is mentioned. USe two bots to
        // simulate the game play
        String firstPlayer = Constants.HUMAN_PLAYER;
        if(args.length > 1 && args[1].equals(Constants.COMMANDLINE_ARG_BOT)) {
            firstPlayer = Constants.BOT_PLAYER;
        }

        try {

            GameController controller = new GameController();
            Player player1 = controller.getPlayerWithBoard(firstPlayer);
            Player player2 = controller.getPlayerWithBoard(Constants.BOT_PLAYER);
            // Enable debug mode if passed as argument
            controller.start(player1, player2);
        } catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }

    /**
     * Gets player with boards initialized.
     *
     * @param playerType the player type either human or a computer bot.
     * @return the {@link Player} object.
     * @throws Exception the exception
     */
    @VisibleForTesting
    protected Player getPlayerWithBoard(String playerType) throws Exception {
        // Initialize myBoard
        Board board = new MyBoard(Constants.BOARD_LENGTH, Constants.BOARD_BREADTH);

        // Initialize player
        Player player = PlayerFactory.getPlayer(playerType, board);

        // player will place their ships
        for(Ship.ShipType shipType: Ship.ShipType.values())
            player.placeShip(shipType);

        if(Constants.DEBUG_MODE)
            System.out.println(board.draw());

        return player;
    }

    /**
     * Start the main game loop with provided players.
     *
     * @param players the players who will be playing the battleship game
     * @throws Exception the exception
     */
    @VisibleForTesting
    protected void start(Player... players) throws Exception {

        boolean activeState = true;
        int playerCount = players.length;
        int currentPlayer = 0;
        int nextPlayer = 1;

        while(activeState) {

            // Get input from current player
            Position position = players[currentPlayer].play();

            if(isValid(position) == false) {
                System.out.println("Invalid input poistion given. try again");
                continue;
            }

            System.out.println("Player " + players[currentPlayer]
                    + " Played " + position.toString());

            // Send input of current player to next player
            AttackResult result = players[nextPlayer].acceptAttack(position, new Missile());

            // update the opponents board for current player using output of next player
            players[currentPlayer].updateOpponentBoard(result);

            // Print the output
            System.out.println(result.getCurrentAttackResult());

            // NOTE: print myBoard and print opponents board here
            players[currentPlayer].drawBothBoards();

            if(result.getActiveShipsRemanining() == 0) {
                System.out.println("All ships destroyed. Winner is "
                        + players[currentPlayer]);
                break;
            }

            currentPlayer = (currentPlayer + 1) % playerCount;
            nextPlayer = (nextPlayer + 1) % playerCount;
        }
    }

    private boolean isValid(Position position) {
        if(position == null)
            return false;
        return position.getX() >= 0
                && position.getX() < Constants.BOARD_LENGTH
                && position.getY() >= 0
                && position.getY() < Constants.BOARD_BREADTH;
    }
}
