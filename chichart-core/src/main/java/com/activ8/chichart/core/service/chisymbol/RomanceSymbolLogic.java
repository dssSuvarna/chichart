package com.activ8.chichart.core.service.chisymbol;

import com.activ8.chichart.core.domain.*;

import java.util.*;

/**
 * If the person’s Day Branch forms a partial 3-Harmony or 6-Harmony with the current day (see Matrix for the types 14_07_18.xlsx in the Day Branches tab) then use the romance symbol,
 * each one will get 3 per month unless a special symbol over-rules.
 */
public class RomanceSymbolLogic {
    private static Map<BranchType,List<BranchType>> combinations = new HashMap<>();

    static {
        combinations.put(BranchType.ZI, Arrays.asList(BranchType.CHOU, BranchType.CHEN, BranchType.SHEN));
        combinations.put(BranchType.CHOU, Arrays.asList(BranchType.ZI, BranchType.SI, BranchType.YOU));
        combinations.put(BranchType.YIN, Arrays.asList(BranchType.WU, BranchType.XU, BranchType.HAI));
        combinations.put(BranchType.MAO, Arrays.asList(BranchType.WEI, BranchType.XU, BranchType.HAI));
        combinations.put(BranchType.CHEN, Arrays.asList(BranchType.ZI, BranchType.SHEN, BranchType.YOU));
        combinations.put(BranchType.SI, Arrays.asList(BranchType.CHOU, BranchType.SHEN, BranchType.YOU));
        combinations.put(BranchType.WU, Arrays.asList(BranchType.YIN, BranchType.WEI, BranchType.XU));
        combinations.put(BranchType.WEI, Arrays.asList(BranchType.MAO, BranchType.WU, BranchType.HAI));
        combinations.put(BranchType.SHEN, Arrays.asList(BranchType.ZI, BranchType.CHEN, BranchType.SI));
        combinations.put(BranchType.YOU, Arrays.asList(BranchType.CHOU, BranchType.CHEN, BranchType.SI));
        combinations.put(BranchType.XU, Arrays.asList(BranchType.YIN, BranchType.MAO, BranchType.WU));
        combinations.put(BranchType.HAI, Arrays.asList(BranchType.YIN, BranchType.MAO, BranchType.WEI));
    }

    public boolean matches(BranchType chartDayBranch, BranchType currentDayBranch) {
        return combinations.get(chartDayBranch).contains(currentDayBranch);
    }
}
