package com.activ8.chichart.core.service.lunarmethod.rank;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.*;

import java.util.*;

public class StandardStemElementRanker {

    private DataService dataService;

    public StandardStemElementRanker(DataService dataService) {
        this.dataService = dataService;
    }

    public List<RankedStem> determineRanks(List<ElementType> rankedElements) {

        List<RankedStem> rankedStems = new ArrayList<>();

        for (Stem stem : dataService.getStems()) {
            rankedStems.add(new RankedStem(stem.getType(), determineScore(stem.getElement().getType(), rankedElements), ScoreReason.ELEMENT));
        }

        return rankedStems;
    }

    private Score determineScore(ElementType elementType, List<ElementType> rankedElements) {
        return Score.determineScore(rankedElements.indexOf(elementType));
    }
}
