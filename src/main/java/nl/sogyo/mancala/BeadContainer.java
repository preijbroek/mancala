package nl.sogyo.mancala;

public abstract class BeadContainer {
    private int beads;
    private BeadContainer neighbour;
    private Player owner;

    void setOwner(Player player) {
        this.owner = player;
    }

    Player getOwner() {
        return this.owner;
    }

    void setNeighbour(BeadContainer beadContainer) {
        this.neighbour = beadContainer;
    }

    BeadContainer getNeighbour() {
        return this.neighbour;
    }

    BeadContainer getNeighbour(int nthNeighbour) {
        switch(nthNeighbour) {
            case (0%14): return this;
            case (1%14): return this.neighbour;
            default: return this.neighbour.getNeighbour(nthNeighbour-1);
        }
    }

    void setBeads(int beadsToBeContained) {
        beads = beadsToBeContained;
    }

    int getBeads() {
        return beads;
    }

    void runEndOfGame() {
        System.out.println("Game over! No legal moves for player with turn");
        this.transferBeadsOnGameEnd(0);
        this.getOwner().setWinner(this.getKalaha().getBeads()-this.getOppositeKalaha().getBeads());
        this.getOwner().showWinner(this.getOwner().getWinner());
    }

    void play(int chosenBowl) {
        this.getNeighbour(chosenBowl-1).play();
    }

    abstract void play();

    abstract BeadContainer getOpposite();
    abstract BeadContainer getOppositeKalaha();
    abstract BeadContainer getKalaha();
    abstract Boolean isMovePossible();

    abstract void transferBeadsOnPlayerMove(int beadsToMove);
    abstract void transferBeadsOnStrike(int beadsToTake);
    abstract void transferBeadsOnGameEnd(int beadsToAdd);


}
