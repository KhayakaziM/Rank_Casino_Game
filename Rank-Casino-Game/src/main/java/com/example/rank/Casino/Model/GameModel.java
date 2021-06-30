package com.example.rank.Casino.Model;

import com.sun.istack.NotNull;

public class GameModel {
        @NotNull
        private String gameType;
        @NotNull
        private String gameDesc;
        @NotNull
        private String gameName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
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
