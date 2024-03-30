package com.activ8.chichart.core.service.lunarmethod.power;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

public class FollowThePowerHarmony extends AbstractFollowLunarMethodHarmony {

    public FollowThePowerHarmony(HarmonyCombinationLogic harmonyCombinationLogic, CombinationLogic combinationLogic) {
        super(harmonyCombinationLogic, combinationLogic);
    }

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
        return 24;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return String.format("Follow Power %s", chart.getDayPillar().getStem().getElement().getName());
    }

}
