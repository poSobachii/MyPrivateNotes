package serverSide.dto;

import serverSide.enums.PlayerInGameDecision;

public class PlayerDecisionRequestDTO {

    Long gameId;
    Long playerId;
    PlayerInGameDecision decision;

    public PlayerDecisionRequestDTO() {
    }

    public PlayerDecisionRequestDTO(Long gameId, Long playerId, PlayerInGameDecision decision) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.decision = decision;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public PlayerInGameDecision getDecision() {
        return decision;
    }

    public void setDecision(PlayerInGameDecision decision) {
        this.decision = decision;
    }
}
