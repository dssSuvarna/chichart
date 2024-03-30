package com.activ8.chichart.core.service.lunarmethod.output;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

public class FollowTheOutputSeasonal extends AbstractFollowLunarMethodSeasonal {

    public FollowTheOutputSeasonal(SeasonalCombinationLogic seasonalCombinationLogic, CombinationLogic combinationLogic) {
        super(seasonalCombinationLogic, combinationLogic);
    }

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
        return 16;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Output %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
