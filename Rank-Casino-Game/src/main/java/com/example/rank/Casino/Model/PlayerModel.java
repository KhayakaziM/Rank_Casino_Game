package com.example.rank.Casino.Model;

import com.sun.istack.NotNull;

import javax.persistence.Column;

public class PlayerModel {

    @NotNull
    private String player_username;
    @NotNull
    private String player_usersurname;


    public PlayerModel() {
    }

    public String getPlayer_usersurname() {
        return player_usersurname;
    }

    public void setPlayer_usersurname(String player_usersurname) {
        this.player_usersurname = player_usersurname;
    }

    public String getPlayer_username() {
        return player_username;
    }

    public void setPlayer_username(String player_username) {
        this.player_username = player_username;
    }
}
