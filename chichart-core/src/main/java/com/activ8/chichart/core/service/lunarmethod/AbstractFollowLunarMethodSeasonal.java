package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

/**
 * When searching for a combination, we check all the FollowTheX elements for a seasonal combination first,
 * before checking for a harmony combination
 */
public abstract class AbstractFollowLunarMethodSeasonal implements LunarMethod {

    private SeasonalCombinationLogic seasonalCombinationLogic;
    private CombinationLogic combinationLogic;

    protected abstract RelationshipType getRelationshipType();

    public AbstractFollowLunarMethodSeasonal(SeasonalCombinationLogic seasonalCombinationLogic, CombinationLogic combinationLogic) {
        this.seasonalCombinationLogic = seasonalCombinationLogic;
        this.combinationLogic = combinationLogic;
    }

    @Override
    public boolean matches(FourPillarsChart chart, int currentAge) {

        Stem dmStem = chart.getDayPillar().getStem();
        ElementType dmRelatedElementType = dmStem.getElement().getRelatedElement(getRelationshipType());

        return seasonalCombinationLogic.isMatch(dmRelatedElementType, combinationLogic.getCombinationBranchTypes(chart.getPillarsList(), currentAge));
    }

}
