package serverSide.dto;

public class GameStatusDTO {

    private final Long gameId;
    private final String notificationText;
    private final boolean running;
    private final int playerBalance;

    public GameStatusDTO(Long id, String notificationText, boolean running, int playerBalance) {
        this.gameId = id;
        this.notificationText = notificationText;
        this.running = running;
        this.playerBalance = playerBalance;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public boolean isRunning() {
        return running;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }
}
