/**
 * The type Hit result.
 */
public class HitResult {

    private Ship.ShipType shipType;
    private Position position;
    private Result result;

    /**
     * The enum Result.
     */
    public enum Result {
        /**
         * The Hit.
         */
        HIT("A hit."),
        /**
         * The Miss.
         */
        MISS("It's a miss."),
        /**
         * The Sunk.
         */
        SUNK("Ship is sunk.");

        private String result;

        Result(String result) {
            this.result = result;
        }

        /**
         * Gets result.
         *
         * @return the result
         */
        public String getResult() {
            return result;
        }
    }

    /**
     * Instantiates a new Hit result.
     *
     * @param result   the result
     * @param position the position
     */
    public HitResult(Result result, Position position) {
        this.result = result;
        this.position = position;
    }

    /**
     * Instantiates a new Hit result.
     *
     * @param shipType the ship type
     * @param result   the result
     * @param position the position
     */
    public HitResult(Ship.ShipType shipType, Result result, Position position) {
        this.shipType = shipType;
        this.result = result;
        this.position = position;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position.
     *
     * @param position the position
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(result.getResult());
        if(shipType != null) {
            sb.append(" ");
            sb.append("Shiptype is " + shipType);
        }
        return sb.toString();
    }
}
