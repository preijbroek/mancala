package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;


public class BowlTest {

    @Test
    public void createsBowls() {
        Bowl bowl = new Bowl(2, new Bowl(), new Player());
        Assert.assertNotNull(bowl);
    }

    @Test
    public void createsBowl() {
        Bowl bowl = new Bowl();
        Assert.assertNotNull(bowl);
    }

    @Test
    public void bowlStartsWithFourBeads() {
        Bowl bowl = new Bowl(2, new Bowl(), new Player());
        Assert.assertEquals(4, bowl.getBeads());
    }

    @Test
    public void neighbouringBowlStartsWithFourBeads() {
        Bowl bowl = new Bowl();
        Assert.assertEquals(4, bowl.getNeighbour().getBeads());
    }

    @Test
    public void bowlsStartWithFourBeads() {
        Bowl bowl = new Bowl();
        Assert.assertEquals(4, bowl.getBeads());
    }

    @Test
    public void bowlsHaveBowlNeighbours() {
        Bowl bowl = new Bowl(2, new Bowl(), new Player());
        Bowl bowl2 = (Bowl) bowl.getNeighbour();
        Assert.assertNotNull(bowl2);
    }

    @Test
    public void bowlHasABowlNeighbour() {
        Bowl bowl = new Bowl();
        Bowl bowl2 = (Bowl) bowl.getNeighbour();
        Assert.assertNotNull(bowl2);
    }

    @Test
    public void neighbourOfNeighbourOfNeighbourOfBowlHasABowlNeighbour() {
        Bowl bowl = new Bowl(2, new Bowl(), new Player());
        Bowl bowl2 = (Bowl) bowl.getNeighbour().getNeighbour().getNeighbour().getNeighbour();
        Assert.assertNotNull(bowl2);
    }

    @Test
    public void bowlHasAKalahaNeighbour() {
        Bowl bowl = new Bowl(6, new Bowl(), new Player());
        Kalaha kalaha = (Kalaha) bowl.getNeighbour();
        Assert.assertNotNull(kalaha);
    }

    @Test
    public void multipleNeighbourFunctionGivesBackANeighbour() {
        Bowl bowl = new Bowl();
        BeadContainer someContainer = bowl.getNeighbour(4);
        Assert.assertNotNull(someContainer);
    }

    @Test
    public void multipleNeighbourFunctionGivesBackTheCorrectBowlNeighbour() {
        Bowl bowl = new Bowl();
        BeadContainer someContainer = bowl.getNeighbour(4);
        Assert.assertSame(someContainer, bowl.getNeighbour().getNeighbour().getNeighbour().getNeighbour());
    }

    @Test
    public void multipleNeighbourFunctionGivesBackTheCorrectKalahaNeighbour() {
        Bowl bowl = new Bowl();
        BeadContainer someContainer = bowl.getNeighbour(6);
        Assert.assertSame(someContainer, bowl.getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour().getNeighbour());
    }

    @Test
    public void eachBeadContainerHasAnOwner() {
        Bowl bowl = new Bowl();
        Assert.assertNotNull(bowl.getOwner());
        Assert.assertNotNull(bowl.getNeighbour(9).getOwner());
        Assert.assertNotNull(bowl.getNeighbour(6).getOwner());
        Assert.assertNotNull(bowl.getNeighbour(13).getOwner());
    }

    @Test
    public void allBeadContainerThatBelongToTheSamePlayerHaveTheSameOwnerWhileTheBeadContainersThatShouldNotBelongToTheSamePlayerHaveDifferentOwners() {
        Bowl bowl = new Bowl();
        Assert.assertSame(bowl.getOwner(), bowl.getNeighbour(3).getOwner());
        Assert.assertSame(bowl.getOwner(), bowl.getNeighbour(6).getOwner());
        Assert.assertNotSame(bowl.getNeighbour(6).getOwner(), bowl.getNeighbour(7).getOwner());
        Assert.assertSame(bowl.getNeighbour(7).getOwner(), bowl.getNeighbour(13).getOwner());
        bowl.play(9);
        Assert.assertEquals(4, bowl.getNeighbour(8).getBeads());
    }

    @Test
    public void bowlHasOppositeBowl() {
        Bowl bowl = new Bowl();
        Assert.assertNotNull(bowl.getOpposite());
    }

    @Test
    public void fourteenthNeighbourOfBowlIsBowlItselfWithIntegerNeighbourMethod() {
        Bowl bowl = new Bowl();
        Assert.assertSame(bowl, bowl.getNeighbour(14));
        Assert.assertSame(bowl.getNeighbour(6), bowl.getNeighbour(20));
        Assert.assertSame(bowl.getNeighbour(27), bowl.getNeighbour(41));
    }

    @Test
    public void getOppositeCorrectlyIdentifiesOppositeBowl() {
        Bowl bowl = new Bowl();
        Assert.assertSame(bowl.getOpposite(), bowl.getNeighbour(12));
        Assert.assertSame(bowl.getNeighbour().getOpposite(), bowl.getNeighbour(11));
        Assert.assertSame(bowl, bowl.getNeighbour(12).getOpposite());
    }

    @Test
    public void bowlsCanBePlayed() {
        Bowl bowl = new Bowl();
        bowl.getNeighbour(1).play();
        Assert.assertEquals(0, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(5).getBeads());
    }

    @Test
    public void bowlsCanOnlyBePlayedIfItIsTheirPlayersTurn() {
        Bowl bowl = new Bowl();
        bowl.getNeighbour(8).play();
        Assert.assertEquals(4, bowl.getNeighbour(8).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(9).getBeads());
        Assert.assertEquals(4, bowl.getNeighbour(12).getBeads());
        bowl.getNeighbour(1).play();
        Assert.assertEquals(0, bowl.getNeighbour(1).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(2).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(3).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(5).getBeads());
    }

    @Test
    public void bowlsStrikeWhenLastBeadIsDroppedInOwnEmptyBowl() {
        Bowl bowl = new Bowl();
        bowl.getNeighbour(4).setBeads(0);
        bowl.play();
        Assert.assertEquals(0, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(4).getOpposite().getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(5, bowl.getNeighbour(6).getBeads());
    }

    @Test
    public void bowlsStrikeWhenLastBeadIsDroppedInOwnEmptyBowlAndOppositeBowlIsNonempty() {
        Bowl bowl = new Bowl();
        bowl.getNeighbour(4).setBeads(0);
        bowl.getNeighbour(4).getOpposite().setBeads(0);
        bowl.play();
        Assert.assertEquals(1, bowl.getNeighbour(4).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(4).getOpposite().getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(13).getBeads());
        Assert.assertEquals(0, bowl.getNeighbour(6).getBeads());
    }

    @Test
    public void bowlIsNotPlayedIfItHasNoBeads() {
        Bowl bowl = new Bowl();
        bowl.setBeads(0);
        bowl.getNeighbour().setBeads(8);
        bowl.play();
        Assert.assertEquals(0, bowl.getBeads());
        Assert.assertEquals(8, bowl.getNeighbour().getBeads());
        Assert.assertTrue(bowl.getOwner().isYourTurn());
    }

    @Test
    public void allBeadsAreMovedToKalahaOfCorrectPlayerWhenThePlayerWhoHasToMakeAMoveHasNoLegalMovesAfterLastMoveEndedInKalaha() {
        Bowl bowl = new Bowl();
        for(int x = 0; x<5; x++) {
            bowl.getNeighbour(x).setBeads(0);
        }
        bowl.getNeighbour(5).setBeads(1);
        bowl.getNeighbour(7).setBeads(27);
        bowl.getNeighbour(5).play();
        for(int x = 0; x<6; x++) {
            Assert.assertEquals(0, bowl.getNeighbour(x).getBeads());
        }
        Assert.assertEquals(1, bowl.getNeighbour(6).getBeads());
        for(int x = 7; x<13; x++) {
            Assert.assertEquals(0, bowl.getNeighbour(x).getBeads());
        }
        Assert.assertEquals(47, bowl.getNeighbour(13).getBeads());
    }

    @Test
    public void correctPlayerIsDisplayedAsWinner() {
        Bowl bowl = new Bowl();
        for(int x = 0; x<5; x++) {
            bowl.getNeighbour(x).setBeads(0);
        }
        bowl.getNeighbour(5).setBeads(1);
        bowl.getNeighbour(7).setBeads(27);
        bowl.getNeighbour(5).play();
        Assert.assertEquals(1, bowl.getNeighbour(6).getBeads());
        Assert.assertEquals(47, bowl.getNeighbour(13).getBeads());
    }

    @Test
    public void lappingTheBoardDoesNotRemoveStonesFromGame() {
        Bowl bowl = new Bowl();
        bowl.setBeads(20);
        for (int x = 1; x <5; x++) {
            bowl.getNeighbour(x).setBeads(0);
        }
        bowl.play();
        Assert.assertEquals(1, bowl.getBeads());
    }

    @Test
    public void playingKalahaDoesNotDoAnything() {
        Bowl bowl = new Bowl();
        bowl.play(7);
        for(int x = 0; x<6; x++) {
            Assert.assertEquals(4, bowl.getNeighbour(x).getBeads());
        }
        Assert.assertEquals(0, bowl.getNeighbour(6).getBeads());
        for(int x = 7; x<13; x++) {
            Assert.assertEquals(4, bowl.getNeighbour(x).getBeads());
        }
        Assert.assertEquals(0, bowl.getNeighbour(13).getBeads());
        Assert.assertTrue(bowl.getOwner().isYourTurn());
    }

}