package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.domain.*;

/**
 * When searching for a combination, if we didn't find a seasonal or harmony we then check for a 'strong presence'
 * of the element in the four pillars chart
 */
public abstract class AbstractFollowLunarMethod implements LunarMethod {

    protected abstract RelationshipType getRelationshipType();

    @Override
    public boolean matches(FourPillarsChart chart, int currentAge) {

        Stem dmStem = chart.getDayPillar().getStem();
        ElementType dmRelatedElementType = dmStem.getElement().getRelatedElement(getRelationshipType());

        long count = 0;

        for (Pillar pillar : chart.getPillarsList()) {
            if (pillar.getBranch() != null && pillar.getBranch().getElement().getType().equals(dmRelatedElementType)) {
                count++;
            }
        }

        return (count >= 3);
    }

}
