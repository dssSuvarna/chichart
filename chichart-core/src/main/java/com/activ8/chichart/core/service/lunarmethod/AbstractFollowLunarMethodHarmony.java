package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.domain.*;
import com.activ8.chichart.core.service.lunarmethod.combination.*;

/**
 * When searching for a combination, if we didnt find a seasonal, we then check each element type for a harmony
 * combination
 */
public abstract class AbstractFollowLunarMethodHarmony implements LunarMethod {

    protected HarmonyCombinationLogic harmonyCombinationLogic;
    private CombinationLogic combinationLogic;

    protected abstract RelationshipType getRelationshipType();

    public AbstractFollowLunarMethodHarmony(HarmonyCombinationLogic harmonyCombinationLogic, CombinationLogic combinationLogic) {
        this.harmonyCombinationLogic = harmonyCombinationLogic;
        this.combinationLogic = combinationLogic;
    }

    @Override
    public boolean matches(FourPillarsChart chart, int currentAge) {

        Stem dmStem = chart.getDayPillar().getStem();
        ElementType dmRelatedElementType = dmStem.getElement().getRelatedElement(getRelationshipType());

        return harmonyCombinationLogic.isMatch(dmRelatedElementType, combinationLogic.getCombinationBranchTypes(chart.getPillarsList(), currentAge));

    }

}
