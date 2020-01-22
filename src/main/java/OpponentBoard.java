import java.util.HashMap;

/**
 * The type Opponent board.
 */
public class OpponentBoard implements Board {

    private final int length;
    private final int breadth;
    private HashMap<Position, PositionInfo> boardPositions = new HashMap<>();

    /**
     * The enum Position info.
     */
    public enum PositionInfo {
        /**
         * Unknown position info.
         */
        UNKNOWN,
        /**
         * Hit position info.
         */
        HIT,
        /**
         * Empty position info.
         */
        EMPTY,
    }

    /**
     * Instantiates a new Opponent board.
     *
     * @param length  the length
     * @param breadth the breadth
     */
    public OpponentBoard(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        for(int i = 0; i < Constants.BOARD_LENGTH; ++i) {
            for (int j = 0; j < Constants.BOARD_BREADTH; ++j) {
                boardPositions.put(new Position(i, j), PositionInfo.UNKNOWN);
            }
        }
    }

    @Override
    public HitResult takeHit(Position position, Weapon weapon) throws Exception {
        throw new Exception("cant take Hits to opponent board");
    }

    @Override
    public boolean addShip(Ship ship, Position starPosition, Position endPosition) throws Exception {
        throw new Exception("cant add ships to opponent board");
    }

    @Override
    public int getActiveShips() throws Exception {
        throw new Exception("cant check for active ships in opponent board");
    }

    @Override
    public boolean isEmpty(Position position) throws Exception {
        throw new Exception("cant check the empty check on opponent board");
    }

    @Override
    public void updateBoard(AttackResult attackResult) {
        if(attackResult.getCurrentAttackResult().getResult() == HitResult.Result.MISS) {
            boardPositions.put(attackResult.getCurrentAttackResult().getPosition(), PositionInfo.EMPTY);
        }
        else {
            boardPositions.put(attackResult.getCurrentAttackResult().getPosition(), PositionInfo.HIT);
        }
    }

    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();

        sb.append("  0 1 2 3 4 5 6 7 8 9\n");
        for (int i = 0; i < length; i++) {
            sb.append( (char)('A' + i) + " ");
            for (int j = 0; j < breadth; j++) {
                Position pos = new Position(i, j);
                switch (boardPositions.get(pos)) {
                    case UNKNOWN:
                        sb.append("* ");
                        break;
                    case HIT:
                        sb.append("X ");
                        break;
                    case EMPTY:
                        sb.append("- ");
                        break;
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
