package com.activ8.chichart.core.service.impl;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class BranchClashLogic {

    private static Map<BranchType, BranchType> clashes = new HashMap<>();

    static {
        clashes.put(BranchType.ZI, BranchType.WU);
        clashes.put(BranchType.CHOU, BranchType.WEI);
        clashes.put(BranchType.YIN, BranchType.SHEN);
        clashes.put(BranchType.MAO, BranchType.YOU);
        clashes.put(BranchType.CHEN, BranchType.XU);
        clashes.put(BranchType.SI, BranchType.HAI);
        clashes.put(BranchType.WU, BranchType.ZI);
        clashes.put(BranchType.WEI, BranchType.CHOU);
        clashes.put(BranchType.SHEN, BranchType.YIN);
        clashes.put(BranchType.YOU, BranchType.MAO);
        clashes.put(BranchType.XU, BranchType.CHEN);
        clashes.put(BranchType.HAI, BranchType.SI);
    }

    public BranchType getClash(BranchType branchType) {
        return clashes.get(branchType);
    }

    public boolean isYearBreaker(FourPillarsChart chart) {
        return getClash(chart.getYearPillar().getBranchType()).equals(chart.getDayPillar().getBranchType());
    }

    public boolean isMonthBreaker(FourPillarsChart chart) {
        return getClash(chart.getMonthPillar().getBranchType()).equals(chart.getDayPillar().getBranchType());
    }

}
