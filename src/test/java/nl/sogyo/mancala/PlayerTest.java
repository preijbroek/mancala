package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void playerCanExist() {
        Player player = new Player();
        Assert.assertNotNull(player);
    }

    @Test
    public void playerHasOpponent() {
        Player player = new Player();
        Assert.assertNotNull(player.getOpponent());
    }

    @Test
    public void playersOpponentsOpponentIsPlayer() {
        Player player = new Player();
        Assert.assertSame(player, player.getOpponent().getOpponent());
    }

    @Test
    public void playerHasTurn() {
        Player player = new Player();
        Assert.assertTrue(player.isYourTurn() || player.getOpponent().isYourTurn());
    }

    @Test
    public void onlyOnePlayerHasTurn() {
        Player player = new Player();
        Assert.assertTrue(player.isYourTurn() == !player.getOpponent().isYourTurn());
    }

    @Test
    public void switchingAPlayersTurnMeansBothPlayersSwitchTurn() {
        Player player = new Player();
        player.setPlayerTurn(true);
        Assert.assertTrue(player.isYourTurn());
        Assert.assertTrue(!player.getOpponent().isYourTurn());
        player.setPlayerTurn(false);
        Assert.assertTrue(player.getOpponent().isYourTurn());
        Assert.assertTrue(!player.isYourTurn());
        player.setPlayerTurn(false);
        Assert.assertTrue(player.isYourTurn());
        Assert.assertTrue(!player.getOpponent().isYourTurn());
    }
}