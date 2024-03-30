package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;

import java.util.*;

/**
 * If the person’s Day Stem (Master) matches one of the Academic days. Using the example above, the Day Stem is Bing, so every time there is a Shen day (eg 12-7-18) the Graduation
 * Hat will be used.
 */
public class AcademicSymbolLogic {
    private static Map<StemType,BranchType> combinations = new HashMap<>();

    static {
        combinations.put(StemType.JIA,BranchType. SI);
        combinations.put(StemType.YI,BranchType.WU);
        combinations.put(StemType.BING,BranchType.SHEN);
        combinations.put(StemType.DING,BranchType.YOU);
        combinations.put(StemType.WU,BranchType.SHEN);
        combinations.put(StemType.JI,BranchType.YOU);
        combinations.put(StemType.GENG,BranchType.HAI);
        combinations.put(StemType.XIN,BranchType.ZI);
        combinations.put(StemType.REN,BranchType.YIN);
        combinations.put(StemType.GUI,BranchType.MAO);
    }

    public boolean matches(StemType chartDayStem, BranchType currentDayBranch) {
        return combinations.get(chartDayStem) == currentDayBranch;
    }
}
