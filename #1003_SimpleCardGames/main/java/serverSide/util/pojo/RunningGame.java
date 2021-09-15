package serverSide.util.pojo;

import serverSide.enums.Game;

import java.util.Set;
import java.util.Stack;

public class RunningGame {

    private static Long idCounter = 1L;

    private final Long id;
    private final Game game;
    private final Stack<Card> deckOfCards;
    private final Set<PlayingPlayer> playersInGame;

    public RunningGame(Game game, Set<PlayingPlayer> playersInGame, Stack<Card> deck) {
        this.id = idCounter++;
        this.game = game;
        this.deckOfCards = deck;
        this.playersInGame = playersInGame;
    }


    public Long getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }

    public Stack<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public Set<PlayingPlayer> getPlayersInGame() {
        return playersInGame;
    }


}
