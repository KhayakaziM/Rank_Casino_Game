package com.example.rank.Casino.Entity;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "game")
public class GameEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long game_Id;
    @Column(name="game_type")
    private String gameType;
    @Column(name="game_desc")
    private String gameDesc;


    @Column(name="game_name")
    private String gameName;
    @CreationTimestamp
    private Date sysDate;



    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
    public Date getSysDate() {
        return sysDate;
    }

    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }

    public long getGame_Id() {
        return game_Id;
    }

    public void setGame_Id(long game_Id) {
        this.game_Id = game_Id;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
    }
}
