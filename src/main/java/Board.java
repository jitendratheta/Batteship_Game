/**
 * Interface for Board.
 */
public interface Board {

    /**
     * Function to accept the hit from attack of opponent player.
     *
     * @param position the {@link Position} of the attack
     * @param weapon   the weapon using which attack is done
     * @return result of the hit done by the weopon
     * @throws Exception the exception
     */
    HitResult takeHit(Position position, Weapon weapon) throws Exception;

    /**
     * Add ship to the board
     *
     * @param ship         Ship ibject which need to be added
     * @param starPosition the star position of the ship
     * @param endPosition  the end position of the ship
     * @return the true on success, fails if ships cant be places with provided co-ordinates
     * @throws Exception the exception
     */
    boolean addShip(Ship ship, final Position starPosition, final Position endPosition) throws Exception;

    /**
     * Gets active ships on the board.
     *
     * @return the active ships count
     * @throws Exception the exception
     */
    int getActiveShips() throws Exception;

    /**
     * Check of the position is empty or contains some ship on it.
     *
     * @param position the position to check for.
     * @return the true if place is empty else false.
     * @throws Exception the exception
     */
    boolean isEmpty(Position position) throws Exception;

    /**
     * Update board board from hit result.
     *
     * @param attackResult the attack result
     */
    void updateBoard(AttackResult attackResult);

    /**
     * Draw the board
     *
     * @return the view of the board as a String
     */
    String draw();
}
