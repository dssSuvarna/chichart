package com.activ8.chichart.core.service.month;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;

import java.util.*;

public class CalendarData {

    private FourPillarsChart chart;
    private List<RankedStem> rankedStems;
    private List<RankedBranch> rankedBranches;

    public CalendarData(FourPillarsChart chart, List<RankedStem> rankedStems, List<RankedBranch> rankedBranches) {
        this.chart = chart;
        this.rankedStems = rankedStems;
        this.rankedBranches = rankedBranches;
    }

    public FourPillarsChart getChart() {
        return chart;
    }

    public RankedStem getRankedStem(StemType stemType) {
        for (RankedStem rs : rankedStems) {
            if (rs.getStemType().equals(stemType)) {
                return rs;
            }
        }

        throw new RuntimeException(String.format("Could not find stemType %s", stemType));
    }

    public RankedBranch getRankedBranch(BranchType branchType) {
        for (RankedBranch rb : rankedBranches) {
            if (rb.getBranchType().equals(branchType)) {
                return rb;
            }
        }

        throw new RuntimeException(String.format("Could not find branchType %s", branchType));

    }

    private String getCssClass(StemType stemType, BranchType branchType) {
        Integer scoreValue = getScoreValue(stemType, branchType);

        switch (scoreValue) {
            case 4: case 3:
                return "very-good";
            case 2: case 1:
                return "good";
            case 0:
                return "average";
            case -1: case -2:
                return "bad";
            case -3: case -4:
                return "very-bad";
            default:
                return "";
        }
    }

    public String getCssClass(Pillar pillar) {
        return getCssClass(pillar.getStemType(), pillar.getBranchType());
    }

    public String getCssClass(StemType stemType) {
        return getCssClass(getScoreValue(stemType));
    }

    public String getCssClass(BranchType branchType) {
        return getCssClass(getScoreValue(branchType));
    }

    private String getCssClass(Integer scoreValue) {
        switch (scoreValue) {
            case 2:
                return "very-good";
            case 1:
                return "good";
            case 0:
                return "average";
            case -1:
                return "bad";
            case -2:
                return "very-bad";
            default:
                return "";
        }
    }

    private Integer getScoreValue(StemType stemType, BranchType branchType) {
        return getRankedStem(stemType).getScore().getScoreValue() + getRankedBranch(branchType).getScore().getScoreValue();
    }

    private Integer getScoreValue(StemType stemType) {
        return getRankedStem(stemType).getScore().getScoreValue();
    }

    private Integer getScoreValue(BranchType branchType) {
        return getRankedBranch(branchType).getScore().getScoreValue();
    }

}
