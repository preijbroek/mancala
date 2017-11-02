package nl.sogyo.mancala;

public class Player {

    private boolean playerTurn = false;
    private Player opponent;
    private String playerName;
    private boolean winner = false;

    public Player() {
        this.setNamePlayer1();
        this.playerTurn = true;
        this.opponent = new Player(this);
    }

    private Player(Player player) {
        this.setNamePlayer2();
        this.opponent = player;
    }

    private void setNamePlayer1() {
        playerName = "Player 1";
    }

    private void setNamePlayer2() {
        playerName = "Player 2";
    }

    private String getPlayerName() {
        return this.playerName;
    }

    Player getOpponent() {
        return opponent;
    }

    boolean isYourTurn() {
        return playerTurn;
    }

    void setPlayerTurn(boolean keepTurn) {
        if (!keepTurn) {
            this.playerTurn = !this.playerTurn;
            this.getOpponent().playerTurn = !this.getOpponent().playerTurn;
        }
    }

    void setWinner(int playerScoreDifference) {
        if (playerScoreDifference > 0) {
            this.winner = true;
        } else if (playerScoreDifference < 0) {
            this.getOpponent().winner = true;
        }
    }

    Player getWinner() {
        if (this.winner) {
            return this;
        } else if (this.getOpponent().winner) {
            return this.getOpponent();
        } else {
            return null;
        }
    }

    void showWinner(Player player) {
        if (player == null) {
            System.out.println("It's a tie!");
        } else {
            System.out.println(player.getPlayerName() + " has won!");
        }
    }
}
