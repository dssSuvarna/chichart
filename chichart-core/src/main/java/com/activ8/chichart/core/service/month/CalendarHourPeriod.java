package com.activ8.chichart.core.service.month;

import com.activ8.chichart.constant.*;
import com.activ8.chichart.core.service.lunarmethod.rank.*;

public class CalendarHourPeriod {

    private HourPeriod hourPeriod;
    private RankedStem rankedStem;
    private RankedBranch rankedBranch;
    private boolean useStem;

    public CalendarHourPeriod(HourPeriod hourPeriod, RankedStem rankedStem, RankedBranch rankedBranch, boolean useStem) {
        this.hourPeriod = hourPeriod;
        this.rankedStem = rankedStem;
        this.rankedBranch = rankedBranch;
        this.useStem = useStem;
    }

    public HourPeriod getHourPeriod() {
        return hourPeriod;
    }

    public RankedStem getRankedStem() {
        return rankedStem;
    }

    public RankedBranch getRankedBranch() {
        return rankedBranch;
    }

    public boolean isUseStem() {
        return useStem;
    }

    public boolean isFavourable() {
        return rankedStem.getScore().getScoreValue() + rankedBranch.getScore().getScoreValue() > 0;
    }

    @Override
    public String toString() {
        return "CalendarHourPeriod{" +
                "hourPeriod=" + hourPeriod +
                ", rankedStem=" + rankedStem +
                ", rankedBranch=" + rankedBranch +
                ", useStem=" + useStem +
                '}';
    }
}
