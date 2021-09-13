package server_side.util.pojo;

import server_side.enums.PlayerInGameDecision;

import java.util.Set;

public class PlayingPlayer extends ConnectedPlayer {

    private PlayerInGameDecision playerInGameDecision;
    private Set<Card> cardsOnHands;

    public PlayingPlayer(ConnectedPlayer connectedPlayer) {
        super(connectedPlayer);
        this.playerInGameDecision = PlayerInGameDecision.UNDECISIONED;
    }

    public PlayerInGameDecision getPlayerInGameAction() {
        return playerInGameDecision;
    }

    public void setPlayerInGameAction(PlayerInGameDecision playerInGameDecision) {
        this.playerInGameDecision = playerInGameDecision;
    }

    public Set<Card> getCardsOnHands() {
        return cardsOnHands;
    }

    public void setCardsOnHands(Set<Card> cardsOnHands) {
        this.cardsOnHands = cardsOnHands;
    }
}
