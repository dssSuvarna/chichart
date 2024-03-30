package com.activ8.chichart.core.service.lunarmethod.rank;

import com.activ8.chichart.core.domain.*;

public class RankedStem {

    private StemType stemType;
    private Score score;
    private ScoreReason scoreReason;

    public RankedStem(StemType stemType, Score score, ScoreReason scoreReason) {
        this.stemType = stemType;
        this.score = score;
        this.scoreReason = scoreReason;
    }

    public StemType getStemType() {
        return stemType;
    }

    public Score getScore() {
        return score;
    }

    public ScoreReason getScoreReason() {
        return scoreReason;
    }

    @Override
    public String toString() {
        return "RankedStem{" +
                "stemType=" + stemType +
                ", score=" + score +
                ", scoreReason=" + scoreReason +
                '}';
    }
}
