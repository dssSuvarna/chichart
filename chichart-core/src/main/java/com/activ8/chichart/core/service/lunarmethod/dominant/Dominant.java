package com.activ8.chichart.core.service.lunarmethod.dominant;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

/**
 * This applies to all day stem elements except earth.
 * "Must have a combination in the Branches that is the same Element as the DM (either 3 Seasonal or 3
 * Harmony or 1⁄2 3 Harmony – refer 02) and it is even more likely
 * present in the chart that are the same Element as the DM.
 */
public class Dominant implements LunarMethod {

    private CombinationLogic combinationLogic;

    public Dominant(CombinationLogic combinationLogic) {
        this.combinationLogic = combinationLogic;
    }

    @Override
    public LunarMethodType getType() {
        return LunarMethodType.DOMINANT;
    }

    //NOTE: cal/weighting for stems of the same element type?
    @Override
    public boolean matches(FourPillarsChart chart, int currentAge) {
        return combinationLogic.getCombination(chart) != null;
    }

    @Override
    public Integer getOrder() {
        return 1;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Dominant %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
