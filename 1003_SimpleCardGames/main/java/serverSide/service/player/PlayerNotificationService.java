package serverSide.service.player;

public interface PlayerNotificationService {

    void gameStatusNotification(String player, Object message);

    void runningGamePlayerNotification(String player, String text, int playerBalance, Boolean isPositive);
}
