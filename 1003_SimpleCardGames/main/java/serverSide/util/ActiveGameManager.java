package serverSide.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import serverSide.dto.GameStatusDTO;
import serverSide.enums.Game;
import serverSide.enums.PlayerInGameDecision;
import serverSide.service.game.CardDeckCreationService;
import serverSide.service.game.GameExecutionService;
import serverSide.service.player.PlayerNotificationService;
import serverSide.util.pojo.ConnectedPlayer;
import serverSide.util.pojo.PlayingPlayer;
import serverSide.util.pojo.RunningGame;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component

public class ActiveGameManager {

    private final Map<Long, RunningGame> ongoingGames;
    private final String GAME_START_NOTIFICATION = "Game has been found and will start soon";
    private final String GAME_ENDED_NOTIFICATION = "Game have ended. Your balance %s tokens";

    @Autowired
    private CardDeckCreationService cardDeckCreationService;
    @Autowired
    private GameExecutionService gameExecutionService;
    @Autowired
    private PlayerNotificationService notificationService;
    @Autowired
    private ActivePlayerManager activePlayerManager;

    private ActiveGameManager() {
        ongoingGames = new ConcurrentHashMap<>();
    }

    public void createNewGame(Game game, Set<ConnectedPlayer> matchedPlayers) {
        LinkedHashSet<PlayingPlayer> inGamePlayers = matchedPlayers.stream().map(PlayingPlayer::new).collect(Collectors.toCollection(LinkedHashSet::new));
        RunningGame ongoingGame = new RunningGame(game, inGamePlayers, cardDeckCreationService.createSimpleDeckOfCards());
        notifyPlayersAboutGameStart(ongoingGame);
        ongoingGames.put(ongoingGame.getId(), ongoingGame);
        gameExecutionService.play(ongoingGame);

    }

    public void endExistingGame(RunningGame runningGame) {
        runningGame.getPlayersInGame().forEach(
                player -> {
                    activePlayerManager.updateInMemoryAndStoredPlayerBalance(player.getId(), player.getBalance());
                    notificationService.gameStatusNotification(player.getNickName(),
                            new GameStatusDTO(runningGame.getId(), String.format(GAME_ENDED_NOTIFICATION, player.getBalance()), false, player.getBalance()));

                }
        );
        ongoingGames.remove(runningGame.getId());

    }

    public void updatePlayerDecisionOnRunningGame(Long gameId, Long playerId, PlayerInGameDecision playerDecision) {
        ongoingGames.get(gameId).getPlayersInGame().forEach(p -> {
            if (p.getId().equals(playerId)) {
                p.setPlayerInGameAction(playerDecision);
            }
        });
    }

    private void notifyPlayersAboutGameStart(RunningGame runningGame) {
        runningGame.getPlayersInGame().forEach(player ->
                notificationService.gameStatusNotification(player.getNickName(),
                        new GameStatusDTO(runningGame.getId(), GAME_START_NOTIFICATION, true, player.getBalance())));

    }

}
