package server_side.service.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import server_side.dto.GameDecisionResponseDTO;

@Service
public class PlayerNotificationServiceImpl implements PlayerNotificationService {


    private final String GAME_STATUS_URl = "/game-status";
    private final String RUNNING_GAME_DECISION_URL = "/running-game-decisions";
    private final String DEFAULT_COLOR = "alert-warning";
    private final String POSITIVE_COLOR = "alert-success";
    private final String NEGATIVE_COLOR = "alert-danger";
    @Autowired
    private SimpMessagingTemplate webSocket;

    @Override
    public void gameStatusNotification(String player, Object message) {
        webSocket.convertAndSend(GAME_STATUS_URl + player, message);
    }

    @Override
    public void runningGamePlayerNotification(String player, String text, int playerBalance, Boolean isPositive) {
        GameDecisionResponseDTO response;
        if (isPositive == null) {
            response = new GameDecisionResponseDTO(text, DEFAULT_COLOR, playerBalance);
        } else {
            response = isPositive ? new GameDecisionResponseDTO(text, POSITIVE_COLOR, playerBalance) : new GameDecisionResponseDTO(text, NEGATIVE_COLOR, playerBalance);
        }
        webSocket.convertAndSend(RUNNING_GAME_DECISION_URL + player, response);
    }
}
