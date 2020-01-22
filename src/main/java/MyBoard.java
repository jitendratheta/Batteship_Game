import java.util.*;

/**
 * The type Default myBoard.
 */
public class MyBoard implements Board {

    private final int length;
    private final int breadth;
    private HashMap<Position, Ship> shipPositions = new HashMap<>();
    private List<Ship> ships = new ArrayList<>();

    /**
     * Instantiates a new Default myBoard.
     *
     * @param length  the length of the myBoard.
     * @param breadth the breadth of the myBoard.
     */
    public MyBoard(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public HitResult takeHit(Position position, Weapon weapon) {
        WeoponHitResult result = weapon.dropAt(position);

        for (Position pos: result.getDestroyedPositions()) {
            if(shipPositions.containsKey(pos)) {
                Ship ship = shipPositions.get(pos);
                ship.getShipActivePosition().remove(pos);
                ship.getShipDestroyedPosition().add(pos);
                if(ship.getShipActivePosition().size() == 0)
                    return new HitResult(ship.getShipType() , HitResult.Result.SUNK, position);
                else
                    return new HitResult(HitResult.Result.HIT, position);
            }
        }

        return new HitResult(HitResult.Result.MISS, position);
    }

    @Override
    public boolean addShip(Ship ship, Position starPosition, Position endPosition) {
        Set<Position> positionSet = new HashSet<>();
        for (int i = starPosition.getX(); i <= endPosition.getX(); i++) {
            for (int j = starPosition.getY(); j <= endPosition.getY(); j++) {
                Position currentPosition = new Position(i, j);
                if(shipPositions.containsKey(currentPosition))
                    return false;
                shipPositions.put(currentPosition, ship);
                positionSet.add(currentPosition);
            }
        }
        ship.setShipActivePosition(positionSet);
        ships.add(ship);
        return true;
    }

    @Override
    public int getActiveShips() {
        int result = 0;
        for (int i = 0; i < ships.size(); i++) {
            if(ships.get(i).getShipActivePosition().size() > 0)
                ++result;
        }
        return result;
    }

    @Override
    public boolean isEmpty(Position position) {
        return shipPositions.containsKey(position) == false;
    }

    @Override
    public void updateBoard(AttackResult attackResult) {
        // Do nothing. take hit function have taken care of it.
    }


    @Override
    public String draw() {

        StringBuilder sb = new StringBuilder();

        sb.append("  0 1 2 3 4 5 6 7 8 9\n");
        for (int i = 0; i < length; i++) {
            sb.append( (char)('A' + i) + " ");
            for (int j = 0; j < breadth; j++) {
                Position pos = new Position(i, j);
                if(shipPositions.containsKey(pos)) {
                    if(shipPositions.get(pos).getShipActivePosition().contains(pos))
                        sb.append("S ");
                    else
                        sb.append("X ");
                } else {
                    sb.append("- ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
