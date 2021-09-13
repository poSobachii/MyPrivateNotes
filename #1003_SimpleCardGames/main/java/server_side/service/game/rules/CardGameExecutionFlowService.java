package server_side.service.game.rules;

import server_side.enums.Game;
import server_side.util.pojo.Card;
import server_side.util.pojo.PlayingPlayer;

import java.util.Set;
import java.util.Stack;

public interface CardGameExecutionFlowService {

    Set<Card> dealCards(Stack<Card> deckOfCards, Game game);

    void resolveRoundResult(Set<PlayingPlayer> playersInGame, Game game);
}
