package server_side.controller.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server_side.dto.PlayerDecisionRequestDTO;
import server_side.util.ActiveGameManager;
import server_side.util.ActivePlayerManager;
import server_side.util.pojo.ConnectedPlayer;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private ActivePlayerManager activePlayerManager;

    @Autowired
    private ActiveGameManager activeGameManager;

    @PostMapping("/connect")
    public ConnectedPlayer connectPlayer(@ModelAttribute("username") String userName) {
        return activePlayerManager.connectPlayer(userName);
    }

    @PostMapping("/disconnect")
    public void disconnectPlayer(@ModelAttribute("userId") Long userId) {
        activePlayerManager.disconnectPlayer(userId);
    }

    @PostMapping("/in-game-decision")
    public void playerDecision(@ModelAttribute PlayerDecisionRequestDTO request) {
        activeGameManager.updatePlayerDecisionOnRunningGame(request.getGameId(), request.getPlayerId(), request.getDecision());
    }


}
