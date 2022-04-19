package serverSide.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import serverSide.entity.Player;
import serverSide.enums.Game;
import serverSide.service.player.PlayerService;
import serverSide.util.pojo.ConnectedPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ActivePlayerManager {

    private final Map<Long, ConnectedPlayer> playersOnline;

    @Autowired
    private PlayerService playerService;

    private ActivePlayerManager() {
        playersOnline = new ConcurrentHashMap<>();
    }

    public ConnectedPlayer connectPlayer(String userName) {
        Player player = playerService.resolvePlayer(userName);
        ConnectedPlayer existingPlayer = playersOnline.get(player.getId());
        if (existingPlayer == null) {
            List<Game> gameList = getAvailableGamesForPlayer();
            ConnectedPlayer connectedPlayer = new ConnectedPlayer(player, gameList);
            playersOnline.put(player.getId(), connectedPlayer);
            return connectedPlayer;
        } else {
            throw new RuntimeException(String.format("Player %s already connected. Can't run in multi-tab", userName));
        }
    }

    public void disconnectPlayer(Long userId) {
        playerService.updatePlayerBalance(userId, playersOnline.get(userId).getBalance());
        playersOnline.remove(userId);
    }

    public ConnectedPlayer checkAndReturnPlayerIsOnline(Long userId) {
        try {
            return playersOnline.get(userId);
        } catch (Exception e) {
            throw new RuntimeException("Player with id " + userId + " have been disconnected");
        }
    }

    public void updateInMemoryAndStoredPlayerBalance(Long playerId, int newBalance) {
        playersOnline.get(playerId).setBalance(newBalance);
        playerService.updatePlayerBalance(playerId, newBalance);
    }

    private List<Game> getAvailableGamesForPlayer() {
        List<Game> games = new ArrayList<>();
        Collections.addAll(games, Game.values());
        return games;
    }
}
