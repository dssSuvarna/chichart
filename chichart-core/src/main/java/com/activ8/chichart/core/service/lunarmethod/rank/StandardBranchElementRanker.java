package com.activ8.chichart.core.service.lunarmethod.rank;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;

import java.util.*;

public class StandardBranchElementRanker {

    private DataService dataService;

    public StandardBranchElementRanker(DataService dataService) {
        this.dataService = dataService;
    }

    public List<RankedBranch> determineRanks(List<ElementType> rankedElements) {

        List<RankedBranch> rankedBranches = new ArrayList<>();

        for (Branch branch : dataService.getBranches()) {
            rankedBranches.add(new RankedBranch(branch.getType(), determineScore(branch.getElement().getType(), rankedElements), ScoreReason.ELEMENT));
        }

        return rankedBranches;
    }

    private Score determineScore(ElementType element, List<ElementType> rankedElements) {
        return Score.determineScore(rankedElements.indexOf(element));
    }
}
