package com.activ8.chichart.core.service.lunarmethod.output;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

/**
 * Must have a Output Element combination (or, it seems, a good number of matches in the branches)
 */
public class FollowTheOutput extends AbstractFollowLunarMethod {

    @Override
    public LunarMethodType getType() {
        return LunarMethodType.FOLLOW_OUTPUT;
    }

    @Override
    protected RelationshipType getRelationshipType() {
        return RelationshipType.OUTPUT;
    }

    @Override
    public Integer getOrder() {
        return 36;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Output %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
