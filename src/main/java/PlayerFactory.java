/**
 * The type Player factory.
 */
public class PlayerFactory {

    /**
     * Gets player.
     *
     * @param playerType the player type
     * @param board      the board
     * @return the player
     */
    public static Player getPlayer(String playerType, Board board) {
        switch (playerType) {
            case Constants.HUMAN_PLAYER:
                return new HumanPlayer(board);
            case Constants.BOT_PLAYER:
                return new BotPlayer(board);
            default:
                return new BotPlayer(board);
        }
    }
}
