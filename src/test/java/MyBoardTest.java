import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyBoardTest {

    private WeoponHitResult weoponHitResult;
    private Weapon weapon;
    private Board board;

    @Before
    public void setup() throws Exception {
        board = new MyBoard(Constants.BOARD_LENGTH, Constants.BOARD_BREADTH);
        board.addShip(new Ship(Ship.ShipType.CARRIER), new Position(2,3), new Position(2, 4));
        weapon =  mock(Weapon.class);
        weoponHitResult = mock(WeoponHitResult.class);
    }

    @Test
    public void testTakeHit() throws Exception {
        Position position = new Position(2,3);
        when(weoponHitResult.getDestroyedPositions()).thenReturn(Collections.singletonList(position));
        when(weapon.dropAt(position)).thenReturn(weoponHitResult);
        HitResult hitResult = board.takeHit(new Position(2, 3), weapon);

        Assert.assertEquals(hitResult.getResult(), HitResult.Result.HIT);
    }

    @Test
    public void testTakeHitWithSunkingTheShip() throws Exception {
        Position position = new Position(2,3);
        Position position2 = new Position(2,4);

        when(weoponHitResult.getDestroyedPositions()).thenReturn(Collections.singletonList(position));
        when(weapon.dropAt(position)).thenReturn(weoponHitResult);
        board.takeHit(position, weapon);

        when(weoponHitResult.getDestroyedPositions()).thenReturn(Collections.singletonList(position2));
        when(weapon.dropAt(position2)).thenReturn(weoponHitResult);
        HitResult hitResult = board.takeHit(position2, weapon);

        Assert.assertEquals(hitResult.getResult(), HitResult.Result.SUNK);
    }

    @Test
    public void testGetActiveShips() throws Exception {
        int activeShips = board.getActiveShips();
        Assert.assertEquals(1, activeShips);
    }

    @Test
    public void testIsEmptyPositive() throws Exception {
        boolean isEmpty = board.isEmpty(new Position(2, 3));
        Assert.assertEquals(false, isEmpty);
    }

    @Test
    public void testIsEmptyNegative() throws Exception {
        boolean isEmpty = board.isEmpty(new Position(7, 3));
        Assert.assertEquals(true, isEmpty);
    }

    @Test
    public void testDrawWithShipPositions() {
        board.draw();
    }

}

