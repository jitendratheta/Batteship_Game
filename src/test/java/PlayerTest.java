import org.junit.Assert;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    @Test
    public void testPlaceShip() throws Exception {
        Board board = new MyBoard(Constants.BOARD_LENGTH, Constants.BOARD_BREADTH);
        Player player = new HumanPlayer(board);
        player.placeShip(Ship.ShipType.CRUISER);
    }

    @Test
    public void testAcceptAttack() throws Exception {
        Board board = new MyBoard(Constants.BOARD_LENGTH, Constants.BOARD_BREADTH);

        Player player = new HumanPlayer(board);
        Weapon weapon = mock(Weapon.class);

        WeoponHitResult weoponHitResult = new WeoponHitResult();
        weoponHitResult.add(new Position(2, 3));
        when(weapon.dropAt(any())).thenReturn(weoponHitResult);
        AttackResult attackResult = player.acceptAttack(new Position(2, 3), weapon);
        Assert.assertEquals(attackResult.getActiveShipsRemanining(), 0);
        Assert.assertEquals(attackResult.getCurrentAttackResult().getResult(), HitResult.Result.MISS);

    }

}

