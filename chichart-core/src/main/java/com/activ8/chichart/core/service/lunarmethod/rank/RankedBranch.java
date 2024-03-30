package com.activ8.chichart.core.service.lunarmethod.rank;

import com.activ8.chichart.core.domain.*;

public class RankedBranch {

    private BranchType branchType;
    private Score score;
    private ScoreReason scoreReason;

    public RankedBranch(BranchType branchType, Score score, ScoreReason scoreReason) {
        this.branchType = branchType;
        this.score = score;
        this.scoreReason = scoreReason;
    }

    public BranchType getBranchType() {
        return branchType;
    }

    public Score getScore() {
        return score;
    }

    public ScoreReason getScoreReason() {
        return scoreReason;
    }

    @Override
    public String toString() {
        return "RankedBranch{" +
                "branchType=" + branchType +
                ", score=" + score +
                ", scoreReason=" + scoreReason +
                '}';
    }
}
