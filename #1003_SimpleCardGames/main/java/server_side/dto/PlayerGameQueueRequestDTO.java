package server_side.dto;

public class PlayerGameQueueRequestDTO {

    private Long userId;
    private Long queuedGameId;

    public PlayerGameQueueRequestDTO() {
    }

    public PlayerGameQueueRequestDTO(Long  userId, Long enterQueueForGame) {
        this.userId = userId;
        this.queuedGameId = enterQueueForGame;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQueuedGameId() {
        return queuedGameId;
    }

    public void setQueuedGameId(Long queuedGameId) {
        this.queuedGameId = queuedGameId;
    }
}
