package serverSide.util.pojo;

import serverSide.entity.Player;
import serverSide.enums.Game;

import java.util.List;

public class ConnectedPlayer {

    private final Long id;
    private final String nickName;
    private final List<Game> availableGameList;
    private int balance;

    private boolean connectionLost;
    private Long connectionLostTimer;

    public ConnectedPlayer(Player player, List<Game> gameList) {
        this.id = player.getId();
        this.nickName = player.getNickName();
        this.balance = player.getBalance();
        this.availableGameList = gameList;

        this.connectionLost = false;            // for reconnection feature
        this.connectionLostTimer = null;
    }

    public ConnectedPlayer(ConnectedPlayer connectedPlayer) {
        this.id = connectedPlayer.id;
        this.nickName = connectedPlayer.nickName;
        this.balance = connectedPlayer.balance;
        this.availableGameList = connectedPlayer.availableGameList;

        this.connectionLost = connectedPlayer.connectionLost;
        this.connectionLostTimer = connectedPlayer.connectionLostTimer;
    }

    public void updateBalance(int changes) {
        this.balance += changes;
    }

    public Long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    public List<Game> getAvailableGameList() {
        return availableGameList;
    }

    public boolean isConnectionLost() {
        return connectionLost;
    }

    public Long getConnectionLostTimer() {
        return connectionLostTimer;
    }
}
