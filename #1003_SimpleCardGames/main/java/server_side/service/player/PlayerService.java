package server_side.service.player;

import server_side.entity.Player;

public interface PlayerService {

    Player resolvePlayer(String userName);

    void updatePlayerBalance(Long playerId, int balance);
}
