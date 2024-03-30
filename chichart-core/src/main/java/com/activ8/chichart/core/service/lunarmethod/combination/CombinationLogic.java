package com.activ8.chichart.core.service.lunarmethod.combination;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class CombinationLogic {

    private SeasonalCombinationLogic seasonalCombinationLogic;

    private HarmonyCombinationLogic harmonyCombinationLogic;

    public CombinationLogic(SeasonalCombinationLogic seasonalCombinationLogic, HarmonyCombinationLogic harmonyCombinationLogic) {
        this.seasonalCombinationLogic = seasonalCombinationLogic;
        this.harmonyCombinationLogic = harmonyCombinationLogic;
    }

    // if there is a seasonal element type, dont check for harmony
    public Combination getCombination(FourPillarsChart chart) {

        ElementType elementType = chart.getDayPillar().getStem().getElement().getType();
        Combination combination = getSeasonalCombination(chart, elementType);
        if (combination == null) {
            combination = getHarmonyCombination(chart, elementType);
        }

        return combination;
    }

    // when trying to find a combination, always exclude the hour pillar
    // also exclude the year pillar for people aged 40 and above
    public List<BranchType> getCombinationBranchTypes(List<Pillar> pillars, int currentAge) {
        List<BranchType> branchTypes = new ArrayList<>();
        for (Pillar pillar : pillars) {
            if (!pillar.getType().equals(PillarType.HOUR) && pillar.getBranch() != null && (currentAge < 40 || !pillar.getType().equals(PillarType.YEAR))) {
                branchTypes.add(pillar.getBranchType());
            }
        }

        return branchTypes;

    }

    private Combination getSeasonalCombination(FourPillarsChart chart, ElementType elementType) {
        return seasonalCombinationLogic.getCombination(chart, elementType);
    }

    private Combination getHarmonyCombination(FourPillarsChart chart, ElementType elementType) {
        return harmonyCombinationLogic.getCombination(chart, elementType);
    }

}