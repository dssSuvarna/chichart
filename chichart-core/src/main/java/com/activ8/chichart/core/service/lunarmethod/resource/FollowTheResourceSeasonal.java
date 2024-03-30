package com.activ8.chichart.core.service.lunarmethod.resource;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

public class FollowTheResourceSeasonal extends AbstractFollowLunarMethodSeasonal {

    public FollowTheResourceSeasonal(SeasonalCombinationLogic seasonalCombinationLogic, CombinationLogic combinationLogic) {
        super(seasonalCombinationLogic, combinationLogic);
    }

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
        return 17;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Resource %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
