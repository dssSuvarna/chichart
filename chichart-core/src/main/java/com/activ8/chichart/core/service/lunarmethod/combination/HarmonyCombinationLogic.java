package com.activ8.chichart.core.service.lunarmethod.combination;

import com.activ8.chichart.core.domain.*;

import java.util.*;

/**
 * Rules - can form 'half combination' if any 2 out of 3 are present. Takes precedence over the 6 Combination set, but not over Seasonal.
 */
public class HarmonyCombinationLogic {

    private List<Combination> combos = new ArrayList<>();

    public HarmonyCombinationLogic() {
        combos.add(new Combination(ElementType.FIRE, Arrays.asList(BranchType.WU, BranchType.XU, BranchType.YIN)));
        combos.add(new Combination(ElementType.WATER, Arrays.asList(BranchType.ZI, BranchType.CHEN, BranchType.SHEN)));
        combos.add(new Combination(ElementType.WOOD, Arrays.asList(BranchType.MAO, BranchType.WEI, BranchType.HAI)));
        combos.add(new Combination(ElementType.METAL, Arrays.asList(BranchType.YOU, BranchType.CHOU, BranchType.SI)));
    }

    public Combination getCombination(FourPillarsChart chart, ElementType elementType) {

        for (Combination combo : combos) {
            List<BranchType> branchTypes = combo.getBranches();

            Set<BranchType> intersection = new HashSet<>(chart.getBranchTypes());
            intersection.retainAll(branchTypes);

            if (intersection.size() >= 2 && (elementType == null || combo.getElementType().equals(elementType))) {
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
        return (intersection.size() >= 2);
    }
}