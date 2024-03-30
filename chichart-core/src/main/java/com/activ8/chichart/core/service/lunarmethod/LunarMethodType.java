package com.activ8.chichart.core.service.lunarmethod;

public enum LunarMethodType {
    DOMINANT,
    DOMINANT_EARTH,
    COMPETITIVE,
    FOLLOW_POWER,
    FOLLOW_WEALTH,
    FOLLOW_OUTPUT,
    FOLLOW_RESOURCE,
    UNKNOWN;

    public boolean isDominant() {
        return this == DOMINANT;
    }
}
