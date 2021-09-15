package serverSide.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import serverSide.enums.Game;
import serverSide.util.pojo.ConnectedPlayer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
@EnableScheduling
public class PlayerQueueManager {

    private final Map<Long, Queue<ConnectedPlayer>> playerQueueByGameId;
    private final String ENTER_QUEUE = "You have entered queue for ";
    private final String LEAVE_QUEUE = "You have left queue";
    private final String QUEUE_NOT_FOUND = "You are not in a queue";

    @Autowired
    private ActivePlayerManager activePlayerManager;

    @Autowired
    private ActiveGameManager gameService;

    private PlayerQueueManager() {
        playerQueueByGameId = new ConcurrentHashMap<>();
        for (Game game : Game.values()) {
            playerQueueByGameId.put(game.getId(), new LinkedList<>());
        }
    }

    @Scheduled(cron = "${game.matchmaking.timer}")
    public void matchMaking() {
        for (Map.Entry<Long, Queue<ConnectedPlayer>> entry : playerQueueByGameId.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                Game game = Game.getGameById(entry.getKey());
                System.out.println("matchmaking in progress for " + game.getGameName());
                while (entry.getValue().size() >= game.getMinPlayerCount()) {
                    matchPlayersForGame(game);
                }
            }
        }

    }

    public String addPlayerToQueue(Long userId, Long gameId) {
        ConnectedPlayer connectedPlayer = activePlayerManager.checkAndReturnPlayerIsOnline(userId);
        playerQueueByGameId.get(gameId).add(connectedPlayer);
        return ENTER_QUEUE + Game.getGameById(gameId).getGameName();
    }

    public String leavePlayerFromQueue(Long userId) {
        ConnectedPlayer connectedPlayer = activePlayerManager.checkAndReturnPlayerIsOnline(userId);
        for (Queue<ConnectedPlayer> playersInQueue : playerQueueByGameId.values()) {
            if (playersInQueue.contains(connectedPlayer)) {
                playersInQueue.remove(connectedPlayer);
                return LEAVE_QUEUE;
            }
        }
        return QUEUE_NOT_FOUND;
    }


    private void matchPlayersForGame(Game game) {
        Set<ConnectedPlayer> matchedPlayers = new HashSet<>();
        int maxP = game.getMaxPlayerCount();
        for (int i = 0; i < maxP; i++) {
            if (!playerQueueByGameId.get(game.getId()).isEmpty()) {
                matchedPlayers.add(playerQueueByGameId.get(game.getId()).remove());
            }
        }
        gameService.createNewGame(game, matchedPlayers);
    }
}
