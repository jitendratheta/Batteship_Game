/**
 * The type Bot player.
 */
public class BotPlayer extends Player {

    /**
     * Instantiates a new Bot player.
     *
     * @param board the board
     */
    public BotPlayer(Board board) {
        super(board);
    }

    @Override
    public Position play() {
        return getPosition();
    }

    private Position getPosition() {
        return new Position(random.nextInt(Constants.BOARD_LENGTH), random.nextInt(Constants.BOARD_LENGTH));
    }
}
