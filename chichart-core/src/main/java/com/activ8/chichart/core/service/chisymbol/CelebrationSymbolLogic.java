package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;

import java.util.*;

/**
 * If the person’s Year Branch matches one of the Celebration days. Using the example above, the Year Branch is Zi, so every time there is a Mao day (eg 10-7-18)
 * the Champagne Symbol will be used. Travel and Academic override Celebration.
 */
public class CelebrationSymbolLogic {
    private static Map<BranchType,BranchType> combinations = new HashMap<>();

    static {
        combinations.put(BranchType.ZI,BranchType.MAO);
        combinations.put(BranchType.CHOU,BranchType.YIN);
        combinations.put(BranchType.YIN,BranchType.CHOU);
        combinations.put(BranchType.MAO,BranchType.ZI);
        combinations.put(BranchType.CHEN,BranchType.HAI);
        combinations.put(BranchType.SI,BranchType.XU);
        combinations.put(BranchType.WU,BranchType.YOU);
        combinations.put(BranchType.WEI,BranchType.SHEN);
        combinations.put(BranchType.SHEN,BranchType.WEI);
        combinations.put(BranchType.YOU,BranchType.WU);
        combinations.put(BranchType.XU,BranchType.SI);
        combinations.put(BranchType.HAI,BranchType.CHEN);
    }

    public boolean matches(BranchType chartDayBranch, BranchType currentDayBranch) {
        return combinations.get(chartDayBranch) == currentDayBranch;
    }
}
