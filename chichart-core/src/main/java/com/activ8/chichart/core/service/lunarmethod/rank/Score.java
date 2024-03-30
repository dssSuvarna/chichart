package com.activ8.chichart.core.service.lunarmethod.rank;

// not sure if this should be an enum or perhaps instead just a number
public enum Score {
    VERY_GOOD(2),
    GOOD(1),
    AVERAGE(0),
    BAD(-1),
    VERY_BAD(-2);

    private Integer scoreValue;

    Score(Integer scoreValue) {
        this.scoreValue = scoreValue;
    }

    public Integer getScoreValue() {
        return scoreValue;
    }

    public static Score determineScore(int index) {
        if (index <= 1) {
            return Score.GOOD;
        } else if (index == 2) {
            return Score.AVERAGE;
        } else {
            return Score.BAD;
        }
    }
}
