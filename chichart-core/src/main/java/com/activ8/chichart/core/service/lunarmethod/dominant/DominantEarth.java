package com.activ8.chichart.core.service.lunarmethod.dominant;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

/**
 * For Earth Dominant, the Earth must be strong in the Branches, with no or very weak Wood in the Stems
 * adjacent to the DM (ie Hour & Month). Prefer to have an appearance of all four Earth Branches, i.e.
 * Chou, Chen, Wei and Xu even if some are doubled up.
 */
public class DominantEarth implements LunarMethod {

    @Override
    public LunarMethodType getType() {
        return LunarMethodType.DOMINANT_EARTH;
    }

    //NOTE: cal/weighting for stems of the same element type?
    @Override
    public boolean matches(FourPillarsChart chart, int currentAge) {

        Stem dmStem = chart.getDayPillar().getStem();
        ElementType dmStemElementType = dmStem.getElement().getType();

        if (dmStemElementType != ElementType.EARTH) {
            return false;
        }

        // if hour or month stem element type is wood, cannot be earth dominant.
        //Note: Sade has wood in month stem. Not sure about how/when this is overpowered by the earth in the branches
        //if (chart.getMonthPillar().getStem().getElement().getType() == ElementType.WOOD) {
        //    return false;
        //}

        long count = 0;

        for (Pillar pillar : chart.getPillarsList()) {
            if (pillar.getBranch() != null && pillar.getBranch().getElement().getType().equals(dmStem.getElement().getType())) {
                count++;
            }
        }

        return (count > 2);
    }

    @Override
    public Integer getOrder() {
        return 2;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return "Dominant Earth";
    }
}
