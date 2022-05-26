package serverSide.controller.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import serverSide.dto.PlayerGameQueueRequestDTO;
import serverSide.util.PlayerQueueManager;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    PlayerQueueManager playerQueueManager;

    @PostMapping("/enter")
    public String enterQueue(@ModelAttribute PlayerGameQueueRequestDTO player) {
        return playerQueueManager.addPlayerToQueue(player.getUserId(), player.getQueuedGameId());
    }

    @PostMapping("/leave")
    public String leaveQueue(@ModelAttribute("userId") Long userId) {
        return playerQueueManager.leavePlayerFromQueue(userId);
    }
}