package com.activ8.chichart.core.service.lunarmethod.resource;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;

/**
 * Must have a Output Element combination (or, it seems, a good number of matches in the branches)
 */
public class FollowTheResource extends AbstractFollowLunarMethod {

    @Override
    public LunarMethodType getType() {
        return LunarMethodType.FOLLOW_RESOURCE;
    }

    @Override
    protected RelationshipType getRelationshipType() {
        return RelationshipType.RESOURCE;
    }

    @Override
    public Integer getOrder() {
        return 37;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Resource %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
