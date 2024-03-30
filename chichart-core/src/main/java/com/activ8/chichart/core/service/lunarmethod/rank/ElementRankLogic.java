package com.activ8.chichart.core.service.lunarmethod.rank;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

import java.util.*;

public class ElementRankLogic {

    private StandardStemElementRanker standardStemElementRanker;

    private StandardBranchElementRanker standardBranchElementRanker;

    private CombinationElementRanker combinationElementRanker;

    public ElementRankLogic(StandardStemElementRanker standardStemElementRanker, StandardBranchElementRanker standardBranchElementRanker, CombinationElementRanker combinationElementRanker) {
        this.standardStemElementRanker = standardStemElementRanker;
        this.standardBranchElementRanker = standardBranchElementRanker;
        this.combinationElementRanker = combinationElementRanker;
    }

    public List<RankedStem> rankStems(FourPillarsChart chart, LunarMethod lunarMethod, List<ElementType> rankedElements) {
        return standardStemElementRanker.determineRanks(rankedElements);
    }

    public List<RankedBranch> rankBranches(FourPillarsChart chart, LunarMethod lunarMethod, List<ElementType> rankedElements) {

        List<RankedBranch> rankedBranches = standardBranchElementRanker.determineRanks(rankedElements);

        if (lunarMethod.getType() == LunarMethodType.DOMINANT) {
            // dominant happens because there is a combination. branches involved in the combination are good elements for the
            // purposes of calculating good days and hours on the monthly calendaer
            rankedBranches = combinationElementRanker.rankBranches(chart, lunarMethod, rankedBranches);
        }

        return rankedBranches;
    }

}
