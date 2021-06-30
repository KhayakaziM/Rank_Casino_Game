package com.example.rank.Casino.Entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long player_Id;
    @Column(name="player_username")
    private String player_username;
    @Column(name="player_surname")
    private String player_usersurname;
    @Column(name="privateKey")
    private String  privateKey;
    @Column(name="final_amount")
    private int  finalAmount;
    @CreationTimestamp
    private Date sysDate;

    public long getPlayer_Id() {
        return player_Id;
    }
    public void setPlayer_Id(long player_Id) {
        this.player_Id = player_Id;
    }

    public String getPlayer_username() {
        return player_username;
    }

    public void setPlayer_username(String player_username) {
        this.player_username = player_username;
    }

    public String getPlayer_usersurname() {
        return player_usersurname;
    }

    public void setPlayer_usersurname(String player_usersurname) {
        this.player_usersurname = player_usersurname;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public int getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(int finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Date getSysDate() {
        return sysDate;
    }
    public void setSysDate(Date sysDate) {
        this.sysDate = sysDate;
    }
}
