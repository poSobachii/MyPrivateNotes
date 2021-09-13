package server_side.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Game {

    ONE_CARD_GAME(1L, "One card Game", 2, 2,1, 1, 3, 10),
    TWO_CARD_GAME(2L, "Two card game", 2,2,2, 2, 5, 20 );

    private static final Map<Long, Game> GAMES_BY_ID = new HashMap<>();

    static {
        for (Game g : values()) {
            GAMES_BY_ID.put(g.getId(), g);
        }
    }

    private final Long id;
    private final String gameName;
    private final int maxPlayerCount;
    private final int minPlayerCount;
    private final int cardsPerPlayer;
    private final int bothFoldCoeff;
    private final int foldPlayCoeff;
    private final int bothPlayCoeff;

    Game(Long id, String gameName, int minPlayerCount, int maxPlayerCount, int cardsPerPlayer, int foldCoeff, int foldPlayCoeff, int playCoeff) {
        this.id = id;
        this.gameName = gameName;
        this.maxPlayerCount = maxPlayerCount;
        this.minPlayerCount = minPlayerCount;
        this.cardsPerPlayer = cardsPerPlayer;
        this.bothFoldCoeff = foldCoeff;
        this.foldPlayCoeff = foldPlayCoeff;
        this.bothPlayCoeff = playCoeff;
    }

    public static Game getGameById(Long id) {
        return GAMES_BY_ID.get(id);
    }

    public Long getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public int getMaxPlayerCount() {
        return maxPlayerCount;
    }

    public int getMinPlayerCount() {
        return minPlayerCount;
    }

    public int getCardsPerPlayer() {
        return cardsPerPlayer;
    }

    public int getBothFoldCoeff() {
        return bothFoldCoeff;
    }

    public int getFoldPlayCoeff() {
        return foldPlayCoeff;
    }

    public int getBothPlayCoeff() {
        return bothPlayCoeff;
    }
}
