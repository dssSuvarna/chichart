package com.activ8.chichart.core.service.lunarmethod.wealth;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

/**
 * Must have a Power Element combination (or, it seems, a good number of matches in the branches)
 */
public class FollowTheWealth extends AbstractFollowLunarMethod {

    @Override
    public LunarMethodType getType() {
        return LunarMethodType.FOLLOW_WEALTH;
    }

    @Override
    protected RelationshipType getRelationshipType() {
        return RelationshipType.WEALTH;
    }

    @Override
    public Integer getOrder() {
        return 35;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Wealth %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
