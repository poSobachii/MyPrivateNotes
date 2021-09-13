package server_side.service.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server_side.entity.Player;
import server_side.repository.PlayerRepository;


@Service
public class PlayerServiceImpl implements PlayerService {

    private final int DEFAULT_TOKENS = 1000;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player resolvePlayer(String userName) {
        Player existingPlayer = playerRepository.findByNickName(userName).orElse(null);
        if(existingPlayer == null) {
            Player newPlayer = new Player(userName, DEFAULT_TOKENS);
            playerRepository.save(newPlayer);
            return newPlayer;
        } else {
            return existingPlayer;
        }
    }

    @Override
    public void updatePlayerBalance(Long playerId, int newBalance) {
        Player player = playerRepository.getOne(playerId);
        player.setBalance(newBalance);
        playerRepository.save(player);
    }
}
