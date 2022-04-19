package serverSide.dto;

public class GameDecisionResponseDTO {

    private final String notificationText;
    private final String notificationColor;
    private final int playerBalance;

    public GameDecisionResponseDTO(String notificationText, String notificationColor, int playerBalance) {
        this.notificationText = notificationText;
        this.notificationColor = notificationColor;
        this.playerBalance = playerBalance;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public String getNotificationColor() {
        return notificationColor;
    }

    public int getPlayerBalance() {
        return playerBalance;
    }
}
