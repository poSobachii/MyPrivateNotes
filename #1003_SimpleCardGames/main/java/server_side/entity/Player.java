package server_side.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "players")
public class Player {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "nick_name", unique = true)
    private String nickName;

    @Column(name = "tokens")
    private int balance;

    public Player() {
    }

    public Player(String nickName, int balance) {
        this.nickName = nickName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
