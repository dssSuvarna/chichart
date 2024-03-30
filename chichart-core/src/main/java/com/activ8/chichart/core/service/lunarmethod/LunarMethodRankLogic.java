package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class LunarMethodRankLogic {

    private List<LunarMethodRank> ranks = new ArrayList<>();

    // add best to worst elements to chart page
    public LunarMethodRankLogic() {
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT, RelationshipType.RESOURCE, 1));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT, RelationshipType.SELF, 2));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT, RelationshipType.OUTPUT, 3));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT, RelationshipType.WEALTH, 4));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT, RelationshipType.POWER, 5));

        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT_EARTH, RelationshipType.RESOURCE, 1));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT_EARTH, RelationshipType.SELF, 2));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT_EARTH, RelationshipType.OUTPUT, 3));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT_EARTH, RelationshipType.WEALTH, 4));
        ranks.add(new LunarMethodRank(LunarMethodType.DOMINANT_EARTH, RelationshipType.POWER, 5));

        ranks.add(new LunarMethodRank(LunarMethodType.COMPETITIVE, RelationshipType.OUTPUT, 1));
        ranks.add(new LunarMethodRank(LunarMethodType.COMPETITIVE, RelationshipType.POWER, 2));
        ranks.add(new LunarMethodRank(LunarMethodType.COMPETITIVE, RelationshipType.SELF, 3));
        ranks.add(new LunarMethodRank(LunarMethodType.COMPETITIVE, RelationshipType.RESOURCE, 4));
        ranks.add(new LunarMethodRank(LunarMethodType.COMPETITIVE, RelationshipType.WEALTH, 5));

        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_POWER, RelationshipType.POWER, 1));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_POWER, RelationshipType.WEALTH, 2));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_POWER, RelationshipType.RESOURCE, 3));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_POWER, RelationshipType.SELF, 4));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_POWER, RelationshipType.OUTPUT, 5));

        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_WEALTH, RelationshipType.WEALTH, 1));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_WEALTH, RelationshipType.OUTPUT, 2));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_WEALTH, RelationshipType.POWER, 3));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_WEALTH, RelationshipType.RESOURCE, 4));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_WEALTH, RelationshipType.SELF, 5));

        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_OUTPUT, RelationshipType.OUTPUT, 1));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_OUTPUT, RelationshipType.WEALTH, 2));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_OUTPUT, RelationshipType.POWER, 3));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_OUTPUT, RelationshipType.SELF, 4));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_OUTPUT, RelationshipType.RESOURCE, 5));

        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_RESOURCE, RelationshipType.RESOURCE, 1));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_RESOURCE, RelationshipType.POWER, 2));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_RESOURCE, RelationshipType.OUTPUT, 3));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_RESOURCE, RelationshipType.WEALTH, 4));
        ranks.add(new LunarMethodRank(LunarMethodType.FOLLOW_RESOURCE, RelationshipType.SELF, 5));

    }

    /**
     * Sorts the various elements from best to worst based on the lunarmethod type and the DM pillar
     */
    public List<ElementType> getRankedElements(LunarMethodType lunarMethodType, Element element) {

        List<LunarMethodRank> data = new ArrayList<>();
        for (LunarMethodRank lmr : ranks) {
            if (lmr.getLunarMethodType() == lunarMethodType) {
                data.add(lmr);
            }
        }
        List<ElementType> elements = new ArrayList<>();

        for (LunarMethodRank lmr : data) {
            elements.add(element.getRelatedElement(lmr.getRelationshipType()));
        }

        return elements;
    }

}
