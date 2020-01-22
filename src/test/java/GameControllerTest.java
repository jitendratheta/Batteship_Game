import org.junit.Test;

public class GameControllerTest {

    @Test
    public void testStart() throws Exception {
        GameController controller = new GameController();
        Player player1 = controller.getPlayerWithBoard(Constants.BOT_PLAYER);
        Player player2 = controller.getPlayerWithBoard(Constants.BOT_PLAYER);
        controller.start(player1, player2);
    }
}
