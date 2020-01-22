import java.util.HashSet;
import java.util.Set;

/**
 * The type Ship.
 */
public class Ship {

    private ShipType shipType;
    private Set<Position> shipActivePosition = new HashSet<>();
    private Set<Position> shipDestroyedPosition = new HashSet<>();

    /**
     * Instantiates a new Ship.
     *
     * @param shipType the ship type
     */
    public Ship(ShipType shipType) {
        this.shipType = shipType;
    }

    /**
     * Gets ship type.
     *
     * @return the ship type
     */
    public ShipType getShipType() {
        return shipType;
    }

    /**
     * Gets ship active position.
     *
     * @return the ship active position
     */
    public Set<Position> getShipActivePosition() {
        return shipActivePosition;
    }

    /**
     * Sets ship active position.
     *
     * @param shipActivePosition the ship active position
     */
    public void setShipActivePosition(Set<Position> shipActivePosition) {
        this.shipActivePosition = shipActivePosition;
    }

    /**
     * Gets ship destroyed position.
     *
     * @return the ship destroyed position
     */
    public Set<Position> getShipDestroyedPosition() {
        return shipDestroyedPosition;
    }

    /**
     * The enum Ship type.
     */
    enum ShipType {
        /**
         * Carrier ship type.
         */
        CARRIER(5),
        /**
         * Battleship ship type.
         */
        BATTLESHIP(4),
        /**
         * Cruiser ship type.
         */
        CRUISER(3),
        /**
         * Submarine ship type.
         */
        SUBMARINE(3),
        /**
         * Destroyer ship type.
         */
        DESTROYER(2);

        private int length;

        ShipType(int length) {
            this.length = length;
        }

        /**
         * Gets length.
         *
         * @return the length
         */
        public int getLength() {
            return length;
        }
    }
}
