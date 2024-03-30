package com.activ8.chichart.core.service.lunarmethod;

import com.activ8.chichart.core.domain.*;

// not a component. used if lunar method cannot be calculated
public class UnknownLunarMethod implements LunarMethod {

    @Override
    public LunarMethodType getType() {
        return LunarMethodType.UNKNOWN;
    }

    @Override
    public boolean matches(FourPillarsChart chart, int currentAge) {
        return false;
    }

    @Override
    public Integer getOrder() {
        return 999;
    }

    @Override
    public String getName(FourPillarsChart chart) {
        return "Unknown";
    }
}
