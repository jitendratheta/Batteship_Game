/**
 * The Missile tyhpe of weopon.
 */
public class Missile implements Weapon {

    // NOTE: weopon properties can be added here

    @Override
    public WeoponHitResult dropAt(Position position) {
        WeoponHitResult result = new WeoponHitResult();
        // Weopon result can be enhanced if required
        result.add(position);
        return result;
    }
}
