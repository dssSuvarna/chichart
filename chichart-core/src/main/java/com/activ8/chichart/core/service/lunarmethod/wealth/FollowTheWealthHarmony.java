package com.activ8.chichart.core.service.lunarmethod.wealth;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

public class FollowTheWealthHarmony extends AbstractFollowLunarMethodHarmony {

    public FollowTheWealthHarmony(HarmonyCombinationLogic harmonyCombinationLogic, CombinationLogic combinationLogic) {
        super(harmonyCombinationLogic, combinationLogic);
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
        return 25;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Wealth %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
