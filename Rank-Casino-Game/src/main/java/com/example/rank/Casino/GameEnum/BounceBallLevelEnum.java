package com.example.rank.Casino.GameEnum;

public enum BounceBallLevelEnum {

    Level_one("level Two",2),
    Level_two("level four",4),
    Level_three("level six",6),
    Level_four("level eight",8),
    Level_five("level 10",10),
    Level_six("level twelve",12),
    Level_seven("level forteen",14),
    Level_eight("level sixteen",16),
    Level_nine("level eighteen",18),
    Level_ten("level twenty",20),
    Level_eleven("level twentytwo",22);


    private final String level;
    private final int points;


    BounceBallLevelEnum(String level, int points) {
        this.level = level;
        this.points = points;
    }

    public String getLevel() {
        return level;
    }

    public int getPoints() {
        return points;
    }

}
