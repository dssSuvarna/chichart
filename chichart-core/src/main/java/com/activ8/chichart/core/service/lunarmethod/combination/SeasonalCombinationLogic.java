package com.activ8.chichart.core.service.lunarmethod.combination;

import com.activ8.chichart.core.domain.*;

import java.util.*;

/**
 * Rules - Must have all three Branches present or combination won't form. Takes first precedence over the other two types.
 */
public class SeasonalCombinationLogic {

    private List<Combination> combos = new ArrayList<>();

    public SeasonalCombinationLogic() {
        combos.add(new Combination(ElementType.FIRE, Arrays.asList(BranchType.WU, BranchType.SI, BranchType.WEI)));
        combos.add(new Combination(ElementType.WATER, Arrays.asList(BranchType.ZI, BranchType.CHOU, BranchType.HAI)));
        combos.add(new Combination(ElementType.WOOD, Arrays.asList(BranchType.MAO, BranchType.YIN, BranchType.CHEN)));
        combos.add(new Combination(ElementType.METAL, Arrays.asList(BranchType.YOU, BranchType.SHEN, BranchType.XU)));
    }

    public Combination getCombination(FourPillarsChart chart, ElementType elementType) {

        for (Combination combo : combos) {
            List<BranchType> branchTypes = combo.getBranches();

            Set<BranchType> intersection = new HashSet<>(chart.getBranchTypes());
            intersection.retainAll(branchTypes);

            if (intersection.size() >= 3 && (elementType == null || combo.getElementType().equals(elementType))) {
                return combo;
            }
        }

        return null;
    }

    public boolean isMatch(ElementType elementType, List<BranchType> branchTypes) {

        Combination combo = null;

        for (Combination c : combos) {
            if (c.getElementType().equals(elementType)) {
                combo = c;
                break;
            }
        }

        if (combo == null) {
            return false;
        }

        Set<BranchType> intersection = new HashSet<>(branchTypes);
        intersection.retainAll(combo.getBranches());

        return (intersection.size() >= 3);
    }

}