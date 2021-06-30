package com.example.rank.Casino.Model;

import com.example.rank.Casino.GameEnum.BounceBallLevelEnum;
import com.sun.istack.NotNull;

import javax.persistence.Column;

public class Score {
    @NotNull
    private long player_Id;
    @NotNull
    private long game_Id;
    @NotNull
    private int points;
    @NotNull
    private String score_description;


    public Score() {

    }

    public String getScore_description() {
        return score_description;
    }

    public void setScore_description(String score_description) {
        this.score_description = score_description;
    }

    public long getPlayer_Id() {
        return player_Id;
    }

    public void setPlayer_Id(long player_Id) {
        this.player_Id = player_Id;
    }

    public long getGame_Id() {
        return game_Id;
    }

    public void setGame_Id(long game_Id) {
        this.game_Id = game_Id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
