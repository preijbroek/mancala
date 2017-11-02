package nl.sogyo.mancala;

public class Kalaha extends BeadContainer {

    private int kalahaPassingsOnGameEnd = 0;

    public Kalaha(int beadContainerCounter, Bowl firstBowl, Player player) {
        this.setOwner(player);
        this.setBeads(0);
        if (beadContainerCounter == 7) {
            player = player.getOpponent();
            this.setNeighbour(new Bowl(beadContainerCounter+1, firstBowl, player));
        } else if (beadContainerCounter == 14) {
            this.setNeighbour(firstBowl);
        }
    }

    void play() {
    }

    BeadContainer getOpposite() {
        return this;
    }

    BeadContainer getOppositeKalaha() {
        return this.getNeighbour(7);
    }

    BeadContainer getKalaha() {
        return this;
    }

    Boolean isMovePossible() {
        return false;
    }

    void transferBeadsOnPlayerMove(int beadsToMove) {
        if (this.getOwner().isYourTurn()) {
            this.setBeads(this.getBeads()+1);
            beadsToMove--;
        }
        this.getNeighbour().transferBeadsOnPlayerMove(beadsToMove);
    }

    void transferBeadsOnStrike(int beadsToTake) {
        if (this.getOwner().isYourTurn()) {
            this.setBeads(this.getBeads()+beadsToTake);
        } else {
            this.getNeighbour().transferBeadsOnStrike(beadsToTake);
        }
    }

    void transferBeadsOnGameEnd(int beadsToAdd) {
        this.setBeads(this.getBeads()+beadsToAdd);
        if (kalahaPassingsOnGameEnd == 0) {
            kalahaPassingsOnGameEnd++;
            this.getNeighbour().transferBeadsOnGameEnd(0);
        }
    }
}
