package nl.sogyo.mancala;

public class Bowl extends BeadContainer {



    public Bowl() {
        Player player = new Player();
        this.setBeads(4);
        Bowl firstBowl = this;
        this.setOwner(player);
        this.setNeighbour(new Bowl(2, firstBowl, player));
    }

    public Bowl(int beadContainerCounter, Bowl firstBowl, Player player) {
        this.setBeads(4);
        this.setOwner(player);
        if((beadContainerCounter > 1 && beadContainerCounter < 6) || (beadContainerCounter > 7 && beadContainerCounter < 13)) {
            this.setNeighbour(new Bowl(beadContainerCounter+1, firstBowl, player));
        } else if (beadContainerCounter == 6 || beadContainerCounter == 13) {
            this.setNeighbour(new Kalaha(beadContainerCounter+1, firstBowl, player));
        }
    }

    void play() {
        if (this.getOwner().isYourTurn()) {
            int beadsToPlay = this.getBeads();
            this.setBeads(0);
            this.getNeighbour().transferBeadsOnPlayerMove(beadsToPlay);
            this.checkGameContinues();
        }
    }

    private void checkGameContinues() {
        if (!this.getKalaha().getNeighbour().isMovePossible() && !this.getOppositeKalaha().getNeighbour().isMovePossible()) {
            this.runEndOfGame();
        }
    }

    BeadContainer getOpposite() {
        return this.getNeighbour().getOpposite().getNeighbour();
    }

    BeadContainer getOppositeKalaha() {
        return this.getNeighbour().getOppositeKalaha();
    }

    BeadContainer getKalaha() {
        return this.getNeighbour().getKalaha();
    }

    Boolean isMovePossible() {
        return this.getBeads()>0 && this.getOwner().isYourTurn() ? true : this.getNeighbour().isMovePossible();
    }

    void transferBeadsOnPlayerMove(int beadsToMove) {
        if (beadsToMove > 1) {
            this.setBeads(this.getBeads()+1);
            this.getNeighbour().transferBeadsOnPlayerMove(beadsToMove-1);
        } else if (beadsToMove == 1) {
            this.setBeads(this.getBeads()+1);
            this.Strike();
            this.getOwner().setPlayerTurn(false);
        }
    }

    private void Strike() {
        if (this.getBeads() == 1 && this.getOwner().isYourTurn() && this.getOpposite().getBeads()>0) {
            this.getOpposite().transferBeadsOnStrike(this.getOpposite().getBeads());
            this.getOpposite().setBeads(0);
            this.transferBeadsOnStrike(this.getBeads());
            this.setBeads(0);
        }
    }

    void transferBeadsOnStrike(int beadsToTake) {
        this.getNeighbour().transferBeadsOnStrike(beadsToTake);
    }

    void transferBeadsOnGameEnd(int beadsToAdd) {
        beadsToAdd = beadsToAdd + this.getBeads();
        this.setBeads(0);
        this.getNeighbour().transferBeadsOnGameEnd(beadsToAdd);
    }


}
