package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class KalahaTest {

    @Test
    public void createKalaha() {
        Kalaha kalaha = new Kalaha(7, new Bowl(), new Player());
        Assert.assertNotNull(kalaha);
    }

    @Test
    public void kalahaHasNoBeadsAtStartOfGame() {
        Kalaha kalaha = new Kalaha(7, new Bowl(), new Player());
        Assert.assertEquals(0, kalaha.getBeads());
    }

    @Test
    public void kalahaHasNoBeadsAtStartOfGameAfterDefiningWholeGameThroughFirstBowl() {
        Bowl bowl = new Bowl();
        Assert.assertEquals(0,bowl.getNeighbour(6).getBeads());
    }

    @Test
    public void kalahaHasANeighbour() {
        Kalaha kalaha = new Kalaha(7, new Bowl(), new Player());
        Bowl bowl = (Bowl) kalaha.getNeighbour();
        Assert.assertNotNull(bowl);
    }

    @Test
    public void KalahaDoesNotHaveANeighbour() {
        Kalaha kalaha = new Kalaha(2, new Bowl(), new Player());
        Bowl bowl = (Bowl) kalaha.getNeighbour();
        Assert.assertNull(bowl);
    }

    @Test
    public void secondKalahaHasNeighbour() {
        Bowl bowl = new Bowl();
        Bowl bowl2 = new Bowl(2, bowl, new Player());
        Assert.assertSame(bowl, (Bowl) bowl.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour());
    }

    @Test
    public void kalahaIsItsOwnOppositeBeadContainer() {
        Bowl bowl = new Bowl();
        Assert.assertSame(bowl.getNeighbour(6), bowl.getNeighbour(6).getOpposite());
        Assert.assertSame(bowl.getNeighbour(13), bowl.getNeighbour(13).getOpposite());
    }

    @Test
    public void kalahaCannotBePlayed() {
        Bowl bowl = new Bowl();
        bowl.getNeighbour(6).play();
        bowl.play(7);
        Assert.assertEquals(0, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(7).getBeads());
    }

    @Test
    public void kalahaOfPlayingPlayerIsUsedWhileTheOtherOneIsSkipped() {
        Bowl bowl = new Bowl();
        for (int x = 0; x<6; x++) {
            bowl.getNeighbour(x).setBeads(8);
        }
        for (int x = 7; x<13; x++) {
            bowl.getNeighbour(x).setBeads(8);
        }
        bowl.getNeighbour(5).play();
        Assert.assertEquals(1, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(9, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(9, bowl.getBeads());
    }

}