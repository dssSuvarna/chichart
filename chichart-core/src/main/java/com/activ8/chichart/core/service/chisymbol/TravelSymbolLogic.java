package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;

import java.util.*;

/**
 * If the person’s Day Branch matches one of the Travel days. Using the example above, the Day Branch is Yin, so every time there is a Shen day (eg 12-7-18) the
 * Travel Symbol will be used. Travel overrides Academic.
 */
public class TravelSymbolLogic {
    private static Map<BranchType,BranchType> combinations = new HashMap<>();

    static {
        combinations.put(BranchType.ZI,BranchType.YIN);
        combinations.put(BranchType.CHOU,BranchType.HAI);
        combinations.put(BranchType.YIN,BranchType.SHEN);
        combinations.put(BranchType.MAO,BranchType.SI);
        combinations.put(BranchType.CHEN,BranchType.YIN);
        combinations.put(BranchType.SI,BranchType.HAI);
        combinations.put(BranchType.WU,BranchType.SHEN);
        combinations.put(BranchType.WEI,BranchType.SI);
        combinations.put(BranchType.SHEN,BranchType.YIN);
        combinations.put(BranchType.YOU,BranchType.HAI);
        combinations.put(BranchType.XU,BranchType.SHEN);
        combinations.put(BranchType.HAI,BranchType.SI);
    }

    public boolean matches(BranchType chartDayBranch, BranchType currentDayBranch) {
        return combinations.get(chartDayBranch) == currentDayBranch;
    }
}
