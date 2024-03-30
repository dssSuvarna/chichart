package com.activ8.chichart.core.service.lunarmethod.power;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

/**
 * Must have a Power Element combination (or, it seems, a good number of matches in the branches)
 */
public class FollowThePower extends AbstractFollowLunarMethod {

    @Override
    public LunarMethodType getType() {
        return LunarMethodType.FOLLOW_POWER;
    }

    @Override
    protected RelationshipType getRelationshipType() {
        return RelationshipType.POWER;
    }

    @Override
    public Integer getOrder() {
        return 34;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Power %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
