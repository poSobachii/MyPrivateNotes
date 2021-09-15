package serverSide.service.player;

import serverSide.entity.Player;

public interface PlayerService {

    Player resolvePlayer(String userName);

    void updatePlayerBalance(Long playerId, int balance);
}
