package server_side.service.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import server_side.dto.GameStatusDTO;
import server_side.enums.PlayerInGameDecision;
import server_side.service.game.rules.CardGameExecutionFlowService;
import server_side.service.player.PlayerNotificationService;
import server_side.util.ActiveGameManager;
import server_side.util.pojo.Card;
import server_side.util.pojo.PlayingPlayer;
import server_side.util.pojo.RunningGame;

import java.util.Set;
import java.util.Stack;

import static server_side.enums.PlayerInGameDecision.UNDECISIONED;

@Service
public class GameExecutionServiceImpl implements GameExecutionService {

    private final String CARD_NOTIFICATION = "You received %s";

    @Autowired
    private PlayerNotificationService notificationService;
    @Autowired
    private CardGameExecutionFlowService cardGameExecutionFlowService;
    @Autowired
    private ActiveGameManager activeGameManager;

    @Override
    @Async
    public void play(RunningGame game) {
        playCardGame(game);
    }

    private void playCardGame(RunningGame runningGame) {
        Set<PlayingPlayer> playersInGame = runningGame.getPlayersInGame();
        Stack<Card> deckOfCards = runningGame.getDeckOfCards();
        while (!runningGame.getDeckOfCards().empty()) {
            for (PlayingPlayer player : playersInGame) {
                player.setCardsOnHands(cardGameExecutionFlowService.dealCards(deckOfCards, runningGame.getGame()));
            }
            notifyPlayersAboutTheirCards(playersInGame);
            waitForPlayerDecision(playersInGame);

            cardGameExecutionFlowService.resolveRoundResult(playersInGame, runningGame.getGame());
            resetPlayerStance(playersInGame);

        }
        activeGameManager.endExistingGame(runningGame);
    }

    private void resetPlayerStance(Set<PlayingPlayer> playingPlayers) {
        playingPlayers.forEach(p -> p.setPlayerInGameAction(UNDECISIONED));
    }

    private void notifyPlayersAboutTheirCards(Set<PlayingPlayer> players) {
        for (PlayingPlayer player : players) {
            player.getCardsOnHands().forEach(card ->
                    notificationService.runningGamePlayerNotification(player.getNickName(), String.format(CARD_NOTIFICATION, card), player.getBalance(), null));
        }
    }

    private void waitForPlayerDecision(Set<PlayingPlayer> players) {
        long end = System.currentTimeMillis() + 30000;
        while ((System.currentTimeMillis() < end) && allPlayerMadeDecision(players)) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean allPlayerMadeDecision(Set<PlayingPlayer> playingPlayers) {
        PlayingPlayer unDecisionedPlayers = playingPlayers.stream().filter(p -> p.getPlayerInGameAction().equals(PlayerInGameDecision.UNDECISIONED)).findFirst().orElse(null);
        return unDecisionedPlayers != null;
    }
}
