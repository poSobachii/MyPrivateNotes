package serverSide.service.game.rules;

import serverSide.enums.Game;
import serverSide.util.pojo.Card;
import serverSide.util.pojo.PlayingPlayer;

import java.util.Set;
import java.util.Stack;

public interface CardGameExecutionFlowService {

    Set<Card> dealCards(Stack<Card> deckOfCards, Game game);

    void resolveRoundResult(Set<PlayingPlayer> playersInGame, Game game);
}
