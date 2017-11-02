package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {

    @Test
    public void createMancala() {
        Mancala mancala = new Mancala();
        Assert.assertNotNull(mancala);
    }

    @Test
    public void fullGame() {
        Bowl bowl = new Bowl();
        bowl.play(1);
        Assert.assertEquals(0, bowl.getBeads());
        for (int x=1; x<5;x++) {
            Assert.assertEquals(5, bowl.getNeighbour(x).getBeads());
        }

        bowl.play(10);
        Assert.assertEquals(0, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(13).getBeads());
        for (int x=10; x<13;x++) {
            Assert.assertEquals(5, bowl.getNeighbour(x).getBeads());
        }

        bowl.play(1);

        bowl.play(11);
        Assert.assertEquals(0, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(13).getBeads());
        for (int x=11; x<13;x++) {
            Assert.assertEquals(6, bowl.getNeighbour(x).getBeads());
        }
        Assert.assertEquals(1, bowl.getBeads());
        Assert.assertEquals(6, bowl.getNeighbour(1).getBeads());

        bowl.play(3);
        Assert.assertEquals(1, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(6, bowl.getNeighbour(3).getBeads());

        bowl.play(8);
        Assert.assertEquals(0, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(12).getBeads());

        bowl.play(2);
        Assert.assertEquals(0, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(6, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(7).getBeads());

        bowl.play(12);
        Assert.assertEquals(0, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(8, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(2, bowl.getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(8, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(8, bowl.getNeighbour(4).getBeads());

        bowl.play(4);
        Assert.assertEquals(0, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(9, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(6, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(11).getBeads());

        bowl.play(10);
        Assert.assertEquals(0, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(11).getBeads());

        bowl.play(5);
        Assert.assertEquals(0, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(8, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(9, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(3, bowl.getBeads());


        bowl.play(8);
        Assert.assertEquals(0, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(8, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(10).getBeads());

        bowl.play(6);
        Assert.assertEquals(0, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(9, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(6, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(10, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(4, bowl.getBeads());

        bowl.play(8);
        Assert.assertEquals(0, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(10, bowl.getNeighbour(8).getBeads());

        bowl.play(1);
        Assert.assertEquals(0, bowl.getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(16, bowl.getNeighbour(6).getBeads());

        bowl.play(13);
        Assert.assertEquals(0, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(1, bowl.getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(16, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(9).getBeads());

        bowl.play(6);
        Assert.assertEquals(0, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(17, bowl.getNeighbour(6).getBeads());

        bowl.play(3);
        Assert.assertEquals(0, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(3, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(18, bowl.getNeighbour(6).getBeads());

        bowl.play(6);
        Assert.assertEquals(0, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(19, bowl.getNeighbour(6).getBeads());

        bowl.play(5);
        Assert.assertEquals(0, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(20, bowl.getNeighbour(6).getBeads());

        bowl.play(6);
        Assert.assertEquals(0, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(21, bowl.getNeighbour(6).getBeads());

        bowl.play(4);
        Assert.assertEquals(0, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(22, bowl.getNeighbour(6).getBeads());

        bowl.play(6);
        Assert.assertEquals(0, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(23, bowl.getNeighbour(6).getBeads());

        bowl.play(2);
        Assert.assertEquals(0, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(2, bowl.getNeighbour(4).getBeads());

        bowl.play(12);
        Assert.assertEquals(0, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(2, bowl.getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(1).getBeads());

        bowl.play(5);
        Assert.assertEquals(0, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(24, bowl.getNeighbour(6).getBeads());

        bowl.play(6);
        Assert.assertEquals(0, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(25, bowl.getNeighbour(6).getBeads());

        bowl.play(4);
        Assert.assertEquals(0, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(27, bowl.getNeighbour(6).getBeads());

        bowl.play(13);
        Assert.assertEquals(0, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(6, bowl.getNeighbour(13).getBeads());

        bowl.play(10);
        Assert.assertEquals(0, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(7, bowl.getNeighbour(13).getBeads());

        bowl.play(13);
        Assert.assertEquals(0, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(8, bowl.getNeighbour(13).getBeads());

        bowl.play(12);
        Assert.assertEquals(0, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(0, bowl.getBeads());
        Assert.assertEquals(11, bowl.getNeighbour(13).getBeads());


        bowl.play(3);
        Assert.assertEquals(0, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(3).getBeads());

        bowl.play(8);
        Assert.assertEquals(0, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(8).getBeads());

        bowl.play(2);

        Assert.assertEquals(0, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(5).getBeads());
        Assert.assertEquals(35, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(7).getBeads());
        Assert.assertEquals(1, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(10).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(11).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(12).getBeads());
        Assert.assertEquals(11, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(0).getBeads());

        bowl.play(7);
        bowl.play(8);
        bowl.play(9);
        for (int beads = 0; beads<6; beads++) {
            Assert.assertEquals(0, bowl.getNeighbour(beads).getBeads());
        }
        for (int beads = 7; beads<13; beads++) {
            Assert.assertEquals(0, bowl.getNeighbour(beads).getBeads());
        }
        Assert.assertEquals(35, bowl.getKalaha().getBeads());
        Assert.assertEquals(13, bowl.getKalaha().getOppositeKalaha().getBeads());
    }

    @Test
    public void getDrawnGame() {
        Bowl bowl = new Bowl();
        for (int x=0; x<5; x++) {
            bowl.getNeighbour(x).setBeads(0);
        }
        bowl.getNeighbour(5).setBeads(1);
        for (int x=6; x<13; x++) {
            bowl.getNeighbour(x).setBeads(0);
        }
        bowl.getNeighbour(13).setBeads(1);
        bowl.play(6);
        Assert.assertEquals(1, bowl.getKalaha().getBeads());
        Assert.assertEquals(1, bowl.getOppositeKalaha().getBeads());
        Assert.assertNull(bowl.getOwner().getWinner());
    }

    @Test
    public void playerScoreBeatingOpponentScoreAlsoGivesCorrectOutput() {
        Bowl bowl = new Bowl();
        for (int x=0; x<14; x++) {
            bowl.getNeighbour(x).setBeads(0);
        }
        bowl.getNeighbour(5).setBeads(1);
        bowl.getNeighbour(6).setBeads(100);
        bowl.getNeighbour(13).setBeads(10);
        bowl.play(6);
        Assert.assertEquals(101,bowl.getKalaha().getBeads());
        Assert.assertEquals(10,bowl.getOppositeKalaha().getBeads());
        Assert.assertSame(bowl.getOwner(), bowl.getOwner().getWinner());
    }

}