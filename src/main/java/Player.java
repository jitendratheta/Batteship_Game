
import java.util.Random;

/**
 * The type Player.
 */
public abstract class Player {

    /**
     * The Board.
     */
    protected Board myBoard;
    /**
     * The Opponent board.
     */
    protected Board opponentBoard;
    /**
     * The Random number generator.
     */
    protected Random random = new Random(System.currentTimeMillis());

    /**
     * Instantiates a new Player.
     *
     * @param myBoard the myBoard
     */
    Player(Board myBoard) {
        this.myBoard = myBoard;
        this.opponentBoard = new OpponentBoard(Constants.BOARD_LENGTH, Constants.BOARD_BREADTH);
    }

    /**
     * Play position.
     *
     * @return the position
     */
    abstract Position play();

    /**
     * Place ship.
     *
     * @param shipType the ship type
     * @throws Exception the exception
     */
    public void placeShip(Ship.ShipType shipType) throws Exception {
        int length = shipType.getLength();
        int[] pts = Util.getValidStrip(length, myBoard);
        if(Constants.DEBUG_MODE)
            System.out.println("Placing ship "
                    + shipType
                    + " at "
                    + Util.getPositionString(new Position(pts[0], pts[1]))
                    + " "
                    + Util.getPositionString(new Position(pts[2], pts[3])));

        myBoard.addShip(new Ship(shipType), new Position(pts[0], pts[1]), new Position(pts[2], pts[3]));
    }

    /**
     * Accept attack attack result.
     *
     * @param position the position
     * @param weapon   the weapon
     * @return the attack result
     * @throws Exception the exception
     */
    public AttackResult acceptAttack(Position position, Weapon weapon) throws Exception {
        HitResult hitResult = myBoard.takeHit(position, weapon);
        int activeShips = myBoard.getActiveShips();
        return new AttackResult(hitResult, activeShips);
    }

    /**
     * Update opponent board.
     *
     * @param attackResult the attack result
     */
    public void updateOpponentBoard(AttackResult attackResult) {
        opponentBoard.updateBoard(attackResult);
    }

    /**
     * Draw both boards.
     */
    public void drawBothBoards() {
        System.out.println(myBoard.draw());
        System.out.println(opponentBoard.draw());
    }
}
