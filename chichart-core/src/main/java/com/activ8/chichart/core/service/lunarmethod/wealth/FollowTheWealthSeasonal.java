package com.activ8.chichart.core.service.lunarmethod.wealth;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

public class FollowTheWealthSeasonal extends AbstractFollowLunarMethodSeasonal {

    public FollowTheWealthSeasonal(SeasonalCombinationLogic seasonalCombinationLogic, CombinationLogic combinationLogic) {
        super(seasonalCombinationLogic, combinationLogic);
    }

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
        return 15;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Wealth %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
