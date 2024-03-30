package com.activ8.chichart.core.service.lunarmethod.rank;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

import java.util.*;

public class CombinationElementRanker {

    private SeasonalCombinationLogic seasonalCombinationLogic;

    private HarmonyCombinationLogic harmonyCombinationLogic;

    public CombinationElementRanker(SeasonalCombinationLogic seasonalCombinationLogic, HarmonyCombinationLogic harmonyCombinationLogic) {
        this.seasonalCombinationLogic = seasonalCombinationLogic;
        this.harmonyCombinationLogic = harmonyCombinationLogic;
    }

    public List<RankedBranch> rankBranches(FourPillarsChart chart, LunarMethod lunarMethod, List<RankedBranch> rankedBranches) {

        if (lunarMethod.getType() != LunarMethodType.DOMINANT) {
            throw new RuntimeException(String.format("Lunar chart type %s not supported", lunarMethod.getType()));
        }

        ElementType elementType = chart.getDayPillar().getStem().getElement().getType();
        Combination seasonalCombination = seasonalCombinationLogic.getCombination(chart, elementType);
        Combination harmonyCombination = harmonyCombinationLogic.getCombination(chart, elementType);

        if (seasonalCombination != null || harmonyCombination != null) {
            boolean seasonal = seasonalCombination != null;
            Combination combination = seasonal ? seasonalCombination : harmonyCombination;

            // for any branches involved in a combination, replace their current score
            List<RankedBranch> newRanks = new ArrayList<>();

            for (RankedBranch rankedBranch : rankedBranches) {

                if (combination.getBranches().contains(rankedBranch.getBranchType())) {
                    newRanks.add(new RankedBranch(rankedBranch.getBranchType(), Score.GOOD, seasonal ? ScoreReason.COMBINATION_SEASONAL : ScoreReason.COMBINATION_HARMONY));
                } else {
                    newRanks.add(rankedBranch);
                }

            }

            return newRanks;
        }

        return rankedBranches;
    }
}
