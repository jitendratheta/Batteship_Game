/**
 * The interface Weapon.
 */
public interface Weapon {

    /**
     * Create a weopon hit result when weopon is droped at position.
     *
     * @param position the position
     * @return the weopon hit result.
     */
    WeoponHitResult dropAt(Position position);
}
