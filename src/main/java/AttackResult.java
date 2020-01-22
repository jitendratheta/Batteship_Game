/**
 * Attack result which wraps the result of a attack done by a player to other player's board
 */
public class AttackResult {

    private final HitResult currentAttackResult;
    private final int activeShipsRemanining;

    /**
     * Instantiates a new Attack result with results.
     *
     * @param currentAttackResult   the current attack result
     * @param activeShipsRemanining the active ships remanining
     */
    public AttackResult(
            HitResult currentAttackResult,
            int activeShipsRemanining) {
        this.currentAttackResult = currentAttackResult;
        this.activeShipsRemanining = activeShipsRemanining;
    }

    /**
     * Gets current attack result.
     *
     * @return the current attack result as {@link String}
     */
    public HitResult getCurrentAttackResult() {
        return currentAttackResult;
    }

    /**
     * Gets active ships remaining.
     *
     * @return the active ships remanining count
     */
    public int getActiveShipsRemanining() {
        return activeShipsRemanining;
    }

}
