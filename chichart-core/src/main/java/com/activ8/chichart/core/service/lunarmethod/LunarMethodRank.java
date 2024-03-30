package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.domain.*;

public class LunarMethodRank {

    private LunarMethodType lunarMethodType;
    private RelationshipType relationshipType;
    private Integer rank;

    public LunarMethodRank(LunarMethodType lunarMethodType, RelationshipType relationshipType, Integer rank) {
        this.lunarMethodType = lunarMethodType;
        this.relationshipType = relationshipType;
        this.rank = rank;
    }

    public LunarMethodType getLunarMethodType() {
        return lunarMethodType;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    public Integer getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "LunarMethodRank{" +
                "lunarMethodType=" + lunarMethodType +
                ", relationshipType=" + relationshipType +
                ", rank=" + rank +
                '}';
    }
}
