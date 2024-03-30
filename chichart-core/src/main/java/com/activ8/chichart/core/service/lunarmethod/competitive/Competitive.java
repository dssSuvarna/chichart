package com.activ8.chichart.core.service.lunarmethod.competitive;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

/**
 * Must have plenty of Branches or Stems of the same Element as the Day Stem.
 * No Branch combinations (that would make it Dominant). All the same Element Branches will be
 * scattered throughout the chart. Competition is stronger if the Month Branch supports the Day Stem.
 */
public class Competitive implements LunarMethod {

    private SeasonalCombinationLogic seasonalCombinationLogic;

    private HarmonyCombinationLogic harmonyCombinationLogic;

    public Competitive(SeasonalCombinationLogic seasonalCombinationLogic, HarmonyCombinationLogic harmonyCombinationLogic) {
        this.seasonalCombinationLogic = seasonalCombinationLogic;
        this.harmonyCombinationLogic = harmonyCombinationLogic;
    }

    public LunarMethodType getType() {
        return LunarMethodType.COMPETITIVE;
    }

    public boolean matches(FourPillarsChart chart, int currentAge) {

        Stem dmStem = chart.getDayPillar().getStem();
        ElementType dmStemElementType = dmStem.getElement().getType();

        // if there is a seasonal or harmony combination, this cannot be competitive
        if (seasonalCombinationLogic.getCombination(chart, dmStemElementType) != null) {
            return false;
        } else {
            if (harmonyCombinationLogic.getCombination(chart, dmStemElementType) != null) {
                return false;
            }
        }

        long count = 0;

        for (Pillar pillar : chart.getPillarsList()) {
            if (pillar.getBranch() != null && pillar.getBranch().getElement().getType().equals(dmStem.getElement().getType())) {
                count++;
            }
        }

        if (chart.getMonthPillar().getStem().getElement().getType() == dmStemElementType) {
            count++;
        }

        if (chart.getYearPillar().getStem().getElement().getType() == dmStemElementType) {
            count++;
        }

        return (count >= 4);
    }

    @Override
    public Integer getOrder() {
        return 3;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Competitive %s", chart.getDayPillar().getStem().getElement().getName());
    }
}
