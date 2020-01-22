import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Weopon hit result encapsulates the result of weopon hitting a position.
 */
public class WeoponHitResult {

    private Set<Position> destroyedPositions = new HashSet<>();

    /**
     * Add destroyed position when weopon was hit.
     *
     * @param position the position
     */
    public void add(Position position) {
        destroyedPositions.add(position);
    }

    /**
     * Gets affected positions.
     *
     * @return the affected positions
     */
    public List<Position> getDestroyedPositions() {
        return new ArrayList<>(destroyedPositions);
    }
}
