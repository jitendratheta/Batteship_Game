import java.util.Objects;

/**
 * The type Position which encapsulates the location on 2D plane.
 */
public class Position {

    private int x;
    private int y;

    /**
     * Instantiates a new Position.
     *
     * @param x the x co-ordinate.
     * @param y the y co-ordinate.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x co-ordinate.
     *
     * @return the x co-ordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets y co-ordinate.
     *
     * @return the y co-ordinate.
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position { " +
                ((char)('A'+ x)) +
                (y) +
                " }";
    }
}
